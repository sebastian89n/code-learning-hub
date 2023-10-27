package com.bastex.codelearninghub.jakartaee.jaxws.client;

import com.bastex.codelearninghub.jaxws.dailyquotesservice.CreateDailyQuoteReq;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.CreateDailyQuoteResp;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.DailyQuoteResponse;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.DailyQuotesService;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.DeleteDailyQuoteByIdReq;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.DeleteDailyQuoteByIdResp;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.GetAllDailyQuotesResp;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.GetDailyQuoteByIdReq;
import com.bastex.codelearninghub.jaxws.dailyquotesservice.GetDailyQuoteByIdResp;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@Slf4j
public class JaxWsClientApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final DailyQuotesService dailyQuotesService = new DailyQuotesService(URI.create("http://localhost:8080/DailyQuotesService?wsdl").toURL());

        final CreateDailyQuoteReq createDailyQuote = prepareDailyQuote("The only constant in the technology industry is change.",
                "Marc Benioff", "user1");

        final CreateDailyQuoteResp createDailyQuoteResp = dailyQuotesService.getDailyQuotesPort().createDailyQuote(createDailyQuote);
        log.info("Quote created with id: {}", createDailyQuoteResp.getQuoteId());

        final CreateDailyQuoteReq createDailyQuote2 = prepareDailyQuote("In our company, we all have 2 jobs: 1) to do our job and 2) to improve it",
                "Toyota", "user2");

        final CreateDailyQuoteResp createDailyQuoteResp2 = dailyQuotesService.getDailyQuotesPort().createDailyQuote(createDailyQuote2);
        log.info("Quote created with id :{}", createDailyQuoteResp2.getQuoteId());

        final GetAllDailyQuotesResp allDailyQuotes = dailyQuotesService.getDailyQuotesPort().getAllDailyQuotes();
        log.info("All daily quotes: ");
        allDailyQuotes.getDailyQuotes().getDailyQuote()
                .forEach(JaxWsClientApp::logDailyQuote);

        final GetDailyQuoteByIdReq getDailyQuoteByIdRequest = new GetDailyQuoteByIdReq();
        getDailyQuoteByIdRequest.setQuoteId(createDailyQuoteResp.getQuoteId());
        final GetDailyQuoteByIdResp dailyQuoteByIdResp = dailyQuotesService.getDailyQuotesPort().getDailyQuoteById(getDailyQuoteByIdRequest);
        log.info("Quote by id: ");
        logDailyQuote(dailyQuoteByIdResp.getDailyQuote());

        final DeleteDailyQuoteByIdReq deleteDailyQuoteByIdReq = new DeleteDailyQuoteByIdReq();
        deleteDailyQuoteByIdReq.setQuoteId(createDailyQuoteResp.getQuoteId());

        final DeleteDailyQuoteByIdResp deleteDailyQuoteByIdResp = dailyQuotesService.getDailyQuotesPort().deleteDailyQuoteById(deleteDailyQuoteByIdReq);
        log.info("Deletion status: {}", deleteDailyQuoteByIdResp.getStatus());
    }

    private static CreateDailyQuoteReq prepareDailyQuote(final String quote, final String author, final String userId) {
        final CreateDailyQuoteReq createDailyQuote = new CreateDailyQuoteReq();
        createDailyQuote.setQuote(quote);
        createDailyQuote.setAuthor(author);
        createDailyQuote.setUserId(userId);
        return createDailyQuote;
    }

    private static void logDailyQuote(final DailyQuoteResponse quote) {
        log.info("{}, {}, {}, {}, {}", quote.getId(), quote.getQuote(), quote.getAuthor(), quote.getUserId(), quote.getCreatedDatetime());
    }
}

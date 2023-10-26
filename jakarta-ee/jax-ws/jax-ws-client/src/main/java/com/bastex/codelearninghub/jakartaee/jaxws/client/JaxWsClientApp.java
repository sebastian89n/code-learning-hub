package com.bastex.codelearninghub.jakartaee.jaxws.client;

import com.bastex.jaxws.dailyquotesservice.CreateDailyQuoteRequestType;
import com.bastex.jaxws.dailyquotesservice.CreateDailyQuoteResponseType;
import com.bastex.jaxws.dailyquotesservice.DailyQuotesService_Service;
import com.bastex.jaxws.dailyquotesservice.GetAllDailyQuotesResponseType;
import lombok.SneakyThrows;

import java.net.URL;

public class JaxWsClientApp {

    @SneakyThrows
    public static void main(final String[] args) {
        final DailyQuotesService_Service dailyQuotesService = new DailyQuotesService_Service(new URL("http://localhost:8080/DailyQuotesService?wsdl"));

        final CreateDailyQuoteRequestType createDailyQuote = new CreateDailyQuoteRequestType();
        createDailyQuote.setQuote("Quote");
        createDailyQuote.setUserId("123");

        final CreateDailyQuoteResponseType dailyQuote = dailyQuotesService.getDailyQuotesServicePort().createDailyQuote(createDailyQuote);

        final GetAllDailyQuotesResponseType allDailyQuotes = dailyQuotesService.getDailyQuotesServicePort().getAllDailyQuotes();

        System.out.println();
    }
}

package com.bastex.codelearninghub.jakartaee.jaxws.server.web;

import com.bastex.codelearninghub.jakartaee.jaxws.server.domain.DailyQuote;
import com.bastex.codelearninghub.jakartaee.jaxws.server.exceptions.DailyQuoteValidationException;
import com.bastex.codelearninghub.jakartaee.jaxws.server.services.DailyQuoteService;
import com.bastex.codelearninghub.jakartaee.jaxws.server.utils.DateFormatUtils;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto.DailyQuoteResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto.StatusResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.requests.CreateDailyQuoteRequest;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.requests.DeleteDailyQuoteByIdRequest;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.requests.GetDailyQuoteByIdRequest;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.CreateDailyQuoteResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.DeleteDailyQuoteByIdResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.GetAllDailyQuotesResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.GetDailyQuoteByIdResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@WebService(name = "DailyQuotesService", serviceName = "DailyQuotesService", portName = "DailyQuotesServicePort", targetNamespace = "http://www.jaxws.bastex.com/DailyQuotesService")
public class DailyQuotesWebService {
    private final DailyQuoteService dailyQuoteService = DailyQuoteService.newInMemoryInstance();

    @WebMethod(operationName = "CreateDailyQuote")
    @WebResult(name = "CreateDailyQuoteResponse")
    public CreateDailyQuoteResponse createDailyQuote(@WebParam(name = "CreateDailyQuoteRequest") final CreateDailyQuoteRequest createDailyQuoteRequest) throws DailyQuoteValidationException {
        final long quoteId = dailyQuoteService.createDailyQuote(createDailyQuoteRequest.getQuote(), createDailyQuoteRequest.getUserId());
        return new CreateDailyQuoteResponse(quoteId);
    }

    @WebMethod(operationName = "DeleteDailyQuoteById")
    @WebResult(name = "DeleteDailyQuoteByIdResponse")
    public DeleteDailyQuoteByIdResponse deleteDailyQuoteById(@WebParam(name = "DeleteDailyQuoteByIdRequest") final DeleteDailyQuoteByIdRequest deleteDailyQuoteByIdRequest) {
        final boolean deleted = dailyQuoteService.deleteDailyQuoteById(deleteDailyQuoteByIdRequest.getQuoteId());
        final StatusResponse status = deleted ? StatusResponse.SUCCESS : StatusResponse.NOT_FOUND;
        return new DeleteDailyQuoteByIdResponse(status);
    }

    @WebMethod(operationName = "GetAllDailyQuotes")
    @WebResult(name = "GetAllDailyQuotesResponse")
    public GetAllDailyQuotesResponse getAllDailyQuotes() {
        final List<DailyQuoteResponse> dailyQuoteResponses = dailyQuoteService.findAllDailyQuotes().stream().map(DailyQuotesWebService::transformToDailyQuoteResponse).toList();

        return new GetAllDailyQuotesResponse(dailyQuoteResponses);
    }

    @WebMethod(operationName = "GetDailyQuoteById")
    @WebResult(name = "GetDailyQuoteByIdResponse")
    public GetDailyQuoteByIdResponse getDailyQuoteById(@WebParam(name = "GetDailyQuoteByIdRequest") final GetDailyQuoteByIdRequest getDailyQuoteByIdRequest) {
        return dailyQuoteService.findDailyQuoteById(getDailyQuoteByIdRequest.getQuoteId()).map(DailyQuotesWebService::transformToDailyQuoteResponse).map(dailyQuoteResponse -> new GetDailyQuoteByIdResponse(dailyQuoteResponse, StatusResponse.SUCCESS)).orElseGet(GetDailyQuoteByIdResponse::new);
    }

    private static DailyQuoteResponse transformToDailyQuoteResponse(final DailyQuote quote) {
        return new DailyQuoteResponse(quote.getId(), quote.getQuote(), quote.getUserId(), DateFormatUtils.formatDate(quote.getCreatedTimestamp()));
    }
}

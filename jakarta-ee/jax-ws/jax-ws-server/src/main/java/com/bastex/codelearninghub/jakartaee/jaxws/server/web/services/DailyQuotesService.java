package com.bastex.codelearninghub.jakartaee.jaxws.server.web.services;

import com.bastex.codelearninghub.jakartaee.jaxws.server.web.requests.CreateDailyQuoteRequest;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.CreateDailyQuoteResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.DeleteDailyQuoteResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.ENCODED, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface DailyQuotesService {
    @WebMethod
    CreateDailyQuoteResponse addDailyQuote(CreateDailyQuoteRequest createDailyQuoteRequest);

    @WebMethod
    DeleteDailyQuoteResponse deleteDailyQuoteById(Long quoteId);
}

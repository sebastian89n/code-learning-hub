package com.bastex.codelearninghub.jakartaee.jaxws.server.web.services;

import com.bastex.codelearninghub.jakartaee.jaxws.server.web.requests.CreateDailyQuoteRequest;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.CreateDailyQuoteResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses.DeleteDailyQuoteResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebService(name = "DailyQuotesService",
        serviceName = "DailyQuotesService",
        portName = "DailyQuotesServicePort",
        targetNamespace = "http://www.jaxws.bastex.com/DailyQuotesService",
        endpointInterface = "com.bastex.codelearninghub.jakartaee.jaxws.server.web.services.DailyQuotesService")
public class DailyQuotesServiceImpl implements DailyQuotesService {
    @Override
    @WebMethod
    @WebResult(name = "CreateDailyQuoteResponse")
    public CreateDailyQuoteResponse addDailyQuote(final CreateDailyQuoteRequest createDailyQuoteRequest) {
        return null;
    }

    @Override
    @WebMethod
    @WebResult(name = "DeleteDailyQuoteResponse")
    public DeleteDailyQuoteResponse deleteDailyQuoteById(@WebParam(name = "quoteId") @XmlElement(required = true) final Long quoteId) {
        return null;
    }
}

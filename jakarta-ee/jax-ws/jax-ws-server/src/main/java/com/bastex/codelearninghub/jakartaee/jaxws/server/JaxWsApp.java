package com.bastex.codelearninghub.jakartaee.jaxws.server;

import com.bastex.codelearninghub.jakartaee.jaxws.server.web.services.DailyQuotesService;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.services.DailyQuotesServiceImpl;
import jakarta.xml.ws.Endpoint;
import lombok.SneakyThrows;

public class JaxWsApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final DailyQuotesService dailyQuotesService = new DailyQuotesServiceImpl();
        Endpoint.publish("http://localhost:8080/DailyQuotesService", dailyQuotesService);
    }
}

package com.bastex.codelearninghub.jakartaee.jaxws.server;

import com.bastex.codelearninghub.jakartaee.jaxws.server.web.DailyQuotesWebService;
import jakarta.xml.ws.Endpoint;
import lombok.SneakyThrows;

public class JaxWsServerApp {
    @SneakyThrows
    public static void main(final String[] args) {
        Endpoint.publish("http://localhost:8080/DailyQuotesService", new DailyQuotesWebService());
    }
}

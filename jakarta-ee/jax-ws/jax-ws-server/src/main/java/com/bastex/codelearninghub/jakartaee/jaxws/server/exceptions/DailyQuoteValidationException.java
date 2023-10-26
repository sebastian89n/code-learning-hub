package com.bastex.codelearninghub.jakartaee.jaxws.server.exceptions;

import jakarta.xml.ws.WebFault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@WebFault(name = "ValidationFault")
public class DailyQuoteValidationException extends Exception {
    private final Fault fault;

    public DailyQuoteValidationException(final String message) {
        fault = new Fault("InsufficientInformationToCompleteActionException", message);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Fault {
        private String faultCode;

        private String faultString;
    }
}

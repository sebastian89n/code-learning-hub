package com.bastex.codelearninghub.jakartaee.jaxws.server.exceptions;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.ws.WebFault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@WebFault(name = "InputValidationFault")
public class InputValidationException extends Exception {
    private final FaultInfo fault;

    public InputValidationException(final String message) {
        fault = new FaultInfo("InsufficientInformationToCompleteActionException", message);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlType(name = "FaultInfo", propOrder = {"faultCode", "faultString"})
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class FaultInfo {
        @XmlElement(name = "faultCode", required = true)
        private String faultCode;

        @XmlElement(name = "faultString", required = true)
        private String faultString;
    }
}

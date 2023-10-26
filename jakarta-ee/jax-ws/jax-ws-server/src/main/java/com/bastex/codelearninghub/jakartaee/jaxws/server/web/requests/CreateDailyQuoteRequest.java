package com.bastex.codelearninghub.jakartaee.jaxws.server.web.requests;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "CreateDailyQuoteRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateDailyQuoteRequest {
    @XmlElement(name = "quote", required = true)
    private String quote;

    @XmlElement(name = "userId", required = true)
    private String userId;
}

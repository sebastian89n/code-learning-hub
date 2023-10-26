package com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto;

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
@XmlType(name = "DailyQuoteResponseType", propOrder = {"id", "quote", "userId", "createdDatetime"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DailyQuoteResponse {
    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "quote", required = true)
    private String quote;

    @XmlElement(name = "userId", required = true)
    private String userId;

    @XmlElement(name = "createdDatetime", required = true)
    private String createdDatetime;
}

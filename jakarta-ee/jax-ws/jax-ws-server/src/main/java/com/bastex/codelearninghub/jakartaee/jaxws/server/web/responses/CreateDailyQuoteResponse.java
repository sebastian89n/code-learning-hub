package com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses;

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
@XmlType(name = "CreateDailyQuoteResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateDailyQuoteResponse {
    @XmlElement(name = "quoteId", required = true)
    private Long quoteId;
}

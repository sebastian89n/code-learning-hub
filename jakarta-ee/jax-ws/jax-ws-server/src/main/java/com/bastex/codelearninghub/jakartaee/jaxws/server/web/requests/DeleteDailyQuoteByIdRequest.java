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
@XmlType(name = "DeleteDailyQuoteByIdReq", propOrder = {"quoteId"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteDailyQuoteByIdRequest {
    @XmlElement(name = "quoteId", required = true)
    private Long quoteId;
}

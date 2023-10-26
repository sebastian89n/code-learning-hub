package com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses;

import com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto.DailyQuoteResponse;
import com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto.StatusResponse;
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
@XmlType(name = "GetDailyQuoteByIdResponseType", propOrder = {"dailyQuote", "status"})
@XmlAccessorType(XmlAccessType.FIELD)
public class GetDailyQuoteByIdResponse {
    @XmlElement(name = "dailyQuote")
    private DailyQuoteResponse dailyQuote;

    @XmlElement(name = "status", required = true)
    private StatusResponse status = StatusResponse.NOT_FOUND;
}

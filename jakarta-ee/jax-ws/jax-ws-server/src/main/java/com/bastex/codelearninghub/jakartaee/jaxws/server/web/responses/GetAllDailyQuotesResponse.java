package com.bastex.codelearninghub.jakartaee.jaxws.server.web.responses;

import com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto.DailyQuoteResponse;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "GetAllDailyQuotesResp", propOrder = {"dailyQuotes"})
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllDailyQuotesResponse {
    @XmlElement(name = "dailyQuote", required = true)
    @XmlElementWrapper(name = "dailyQuotes")
    private List<DailyQuoteResponse> dailyQuotes = new ArrayList<>();
}

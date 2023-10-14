package com.bastex.codelearninghub.jakartaee.jaxrs.web.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbacksListResponse {
    private List<FeedbackResponse> feedbacks = new ArrayList<>();
}

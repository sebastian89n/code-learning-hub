package com.bastex.codelearninghub.jakartaee.jaxrs.web.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackRequest {
    private String text;

    private String userId;
}

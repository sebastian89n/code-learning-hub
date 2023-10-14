package com.bastex.codelearninghub.jakartaee.jaxrs.web.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse {
    private Long id;

    private String text;

    private String userId;

    private String created;
}

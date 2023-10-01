package com.bastex.codelearninghub.spring.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private Long id;

    private String email;

    private String firstName;

    private String lastName;
}

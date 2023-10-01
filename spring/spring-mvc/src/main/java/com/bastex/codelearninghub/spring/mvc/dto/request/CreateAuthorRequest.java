package com.bastex.codelearninghub.spring.mvc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorRequest {
    private String email;

    private String firstName;

    private String lastName;
}

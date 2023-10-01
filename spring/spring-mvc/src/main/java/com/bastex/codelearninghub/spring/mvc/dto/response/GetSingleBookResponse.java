package com.bastex.codelearninghub.spring.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSingleBookResponse {
    private BookResponse book;
}

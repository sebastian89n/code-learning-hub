package com.bastex.codelearninghub.spring.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBooksResponse {
    private List<BookResponse> books = new ArrayList<>();
}

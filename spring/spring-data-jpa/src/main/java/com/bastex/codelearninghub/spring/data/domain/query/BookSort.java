package com.bastex.codelearninghub.spring.data.domain.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
@Getter
public enum BookSort {
    idAscending(Sort.by("id").ascending()),
    idDescending(Sort.by("id").descending()),
    titleAscending(Sort.by("title").ascending()),
    titleDescending(Sort.by("title").descending());

    private final Sort sort;
}

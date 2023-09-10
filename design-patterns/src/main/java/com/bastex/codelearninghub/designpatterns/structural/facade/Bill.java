package com.bastex.codelearninghub.designpatterns.structural.facade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Bill {
    @Getter
    private final Integer amount;
}

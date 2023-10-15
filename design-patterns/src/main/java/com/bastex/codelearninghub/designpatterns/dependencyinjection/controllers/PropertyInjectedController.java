package com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers;

import com.bastex.codelearninghub.designpatterns.dependencyinjection.services.MathService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PropertyInjectedController {
    public MathService mathService;

    public long multiply(final long number1, final long number2) {
        final long result = mathService.multiply(number1, number2);
        log.info("{} multiply {} * {} = {}", this.getClass().getSimpleName(), number1, number2, result);
        return result;
    }
}

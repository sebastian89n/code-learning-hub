package com.bastex.codelearninghub.designpatterns.dependencyinjection.services;

public class MathServiceImpl implements MathService {
    @Override
    public long multiply(final long number1, final long number2) {
        return number1 * number2;
    }
}

package com.bastex.codelearninghub.spring.aop.service;

public interface MathService {
    int add(Integer num1, Integer num2);

    int subtract(int subtractFrom, int amountToSubtract);

    int subtractFromHighest(int num1, int num2);

    int multiply(int num1, int num2);

    int multiplyChain(int num1, int num2, int... nums);
}

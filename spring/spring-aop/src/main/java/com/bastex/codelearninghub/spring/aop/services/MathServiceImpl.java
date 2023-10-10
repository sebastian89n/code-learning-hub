package com.bastex.codelearninghub.spring.aop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class MathServiceImpl implements MathService {
    @Override
    public int add(final Integer num1, final Integer num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(final int subtractFrom, final int amountToSubtract) {
        return subtractFrom - amountToSubtract;
    }

    @Override
    public int subtractFromHighest(final int num1, final int num2) {
        return num1 > num2 ? num1 - num2 : num2 - num1;
    }

    @Override
    public int multiply(final int num1, final int num2) {
        return num1 * num2;
    }

    @Override
    public int multiplyChain(final int num1, final int num2, final int... nums) {
        int result = multiply(num1, num2);
        for (final int num : nums) {
            result *= num;
        }
        return result;
    }
}

package com.bastex.codelearninghub.algorithms.recursion;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Factorial
 * <p>
 * 1! = 0! * 1 = 1
 * 2! = 2 * 1 = 2 * 1!
 * 3! = 3 * 2 * 1 = 3 * 2!
 * 4! = 4 * 3 * 2 * 1 = 4 * 3!
 * <p>
 * n! = n * (n - 1)!
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FactorialCalculator {
    private static final String NEGATIVE_NUM_ERROR_MSG = "Number must be a positive integer";

    public static int calculateFactorialIteratively(final int num) {
        if (num < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR_MSG);
        }

        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static int calculateFactorialRecursively(final int num) {
        if (num < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR_MSG);
        }

        if (num == 0) {
            return 1;
        }

        return num * calculateFactorialRecursively(num - 1);
    }
}

package com.bastex.codelearninghub.algorithms.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialCalculatorTest {
    @Test
    void calculateFactorialIteratively_NumIsNegativeValue_ShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorialIteratively(-5));
    }

    @Test
    void calculateFactorialIteratively_NumIsEqualOne_ShouldReturn1() {
        final int result = FactorialCalculator.calculateFactorialIteratively(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void calculateFactorialIteratively_CalculateFactorialResult_ShouldReturnProperValue() {
        final int result = FactorialCalculator.calculateFactorialIteratively(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    void calculateFactorialIteratively_CalculateFactorialResult2_ShouldReturnProperValue() {
        final int result = FactorialCalculator.calculateFactorialIteratively(10);
        Assertions.assertEquals(3628800, result);
    }

    @Test
    void calculateFactorialRecursively_NumIsNegativeValue_ShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorialRecursively(-5));
    }

    @Test
    void calculateFactorialRecursively_NumIsEqualOne_ShouldReturn1() {
        final int result = FactorialCalculator.calculateFactorialRecursively(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void calculateFactorialRecursively_CalculateFactorialResult_ShouldReturnProperValue() {
        final int result = FactorialCalculator.calculateFactorialRecursively(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    void calculateFactorialRecursively_CalculateFactorialResult2_ShouldReturnProperValue() {
        final int result = FactorialCalculator.calculateFactorialRecursively(10);
        Assertions.assertEquals(3628800, result);
    }
}
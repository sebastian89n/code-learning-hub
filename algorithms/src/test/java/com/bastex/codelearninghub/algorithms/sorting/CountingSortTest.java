package com.bastex.codelearninghub.algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CountingSortTest {
    @Test
    void countingSort_ArrayIsNull_ShouldReturnNull() {
        Assertions.assertNull(CountingSort.countingSort(null, 0, 0));
    }

    @Test
    void countingSort_ArrayIsEmpty_ShouldReturnEmptyArray() {
        final int[] result = CountingSort.countingSort(new int[0], 0, 0);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void countingSort_ArrayHasOnlyOneElement_ShouldReturnSameArray() {
        final int[] arrayToSort = {5};
        final int[] result = CountingSort.countingSort(arrayToSort, 5, 5);
        assertNotNull(result);
        assertEquals(arrayToSort, result);
    }

    @Test
    void countingSort_ArrayIsAlreadySorted_ShouldReturnSameSortedArray() {
        final int[] arrayToSort = {1, 2, 3, 4, 5};
        final int[] result = CountingSort.countingSort(arrayToSort, 1, 5);
        assertNotNull(result);
        assertEquals(arrayToSort, result);
    }

    @Test
    void countingSort_ArrayIsNotSortedWithDuplicateElements_ShouldReturnSortedArray() {
        final int[] arrayToSort = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        final int[] result = CountingSort.countingSort(arrayToSort, 2, 10);
        assertNotNull(result);
        assertArrayEquals(new int[]{2, 2, 3, 4, 5, 7, 8, 8, 9, 10}, result);
    }

}
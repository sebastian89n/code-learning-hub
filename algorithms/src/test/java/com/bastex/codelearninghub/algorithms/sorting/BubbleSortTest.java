package com.bastex.codelearninghub.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    @Test
    void sortArray_ArrayIsNull_ShouldReturnNull() {
        assertNull(BubbleSort.sortArray(null));
    }

    @Test
    void sortArray_ArrayIsEmpty_ShouldReturnEmptyArray() {
        final int[] result = BubbleSort.sortArray(new int[0]);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void sortArray_ArrayIsAlreadySorted_ShouldReturnSameSortedArray() {
        final int[] arrayToSort = {1, 2, 3, 4, 5};
        final int[] result = BubbleSort.sortArray(arrayToSort);
        assertNotNull(result);
        assertEquals(arrayToSort, result);
    }

    @Test
    void sortArray_ArrayIsNotSorted_ShouldReturnSortedArray() {
        final int[] arrayToSort = {8, -2, 21, 1, -31};
        final int[] result = BubbleSort.sortArray(arrayToSort);
        assertNotNull(result);
        assertArrayEquals(new int[]{-31, -2, 1, 8, 21}, result);
    }
}
package com.bastex.codelearninghub.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class SortAlgorithmTest {
    private static final List<SortAlgorithm> SORT_ALGORITHMS = List.of(
            new BubbleSort(),
            new SelectionSort(),
            new InsertionSort(),
            new ShellSort(),
            new MergeSort()
    );

    @Test
    void sortArray_ArrayIsNull_ShouldReturnNull() {
        SORT_ALGORITHMS.forEach(sortAlgorithm -> assertNull(sortAlgorithm.sortArray(null),
                () -> sortAlgorithm.getSortAlgorithmType().getName()));
    }

    @Test
    void sortArray_ArrayIsEmpty_ShouldReturnEmptyArray() {
        SORT_ALGORITHMS.forEach(sortAlgorithm -> {
            final int[] result = sortAlgorithm.sortArray(new int[0]);
            assertNotNull(result, () -> sortAlgorithm.getSortAlgorithmType().getName());
            assertEquals(0, result.length, () -> sortAlgorithm.getSortAlgorithmType().getName());
        });
    }

    @Test
    void sortArray_ArrayHasOnlyOneElement_ShouldReturnSameArray() {
        SORT_ALGORITHMS.forEach(sortAlgorithm -> {
            final int[] arrayToSort = {5};
            final int[] result = sortAlgorithm.sortArray(arrayToSort);
            assertNotNull(result, () -> sortAlgorithm.getSortAlgorithmType().getName());
            assertEquals(arrayToSort, result, () -> sortAlgorithm.getSortAlgorithmType().getName());
        });
    }

    @Test
    void sortArray_ArrayIsAlreadySorted_ShouldReturnSameSortedArray() {
        SORT_ALGORITHMS.forEach(sortAlgorithm -> {
            final int[] arrayToSort = {1, 2, 3, 4, 5};
            final int[] result = sortAlgorithm.sortArray(arrayToSort);
            assertNotNull(result);
            assertEquals(arrayToSort, result, () -> sortAlgorithm.getSortAlgorithmType().getName());
        });
    }

    @Test
    void sortArray_ArrayIsNotSorted_ShouldReturnSortedArray() {
        SORT_ALGORITHMS.forEach(sortAlgorithm -> {
            final int[] arrayToSort = {8, -2, 21, 1, -31};
            final int[] result = sortAlgorithm.sortArray(arrayToSort);
            assertNotNull(result, () -> sortAlgorithm.getSortAlgorithmType().getName());
            assertArrayEquals(new int[]{-31, -2, 1, 8, 21}, result, () -> sortAlgorithm.getSortAlgorithmType().getName());
        });
    }

    @Test
    void sortArray_ArrayIsNotSortedWithDuplicateElements_ShouldReturnSortedArray() {
        SORT_ALGORITHMS.forEach(sortAlgorithm -> {
            final int[] arrayToSort = {8, -2, 21, 21, 1, -31, -55, 123};
            final int[] result = sortAlgorithm.sortArray(arrayToSort);
            assertNotNull(result, () -> sortAlgorithm.getSortAlgorithmType().getName());
            assertArrayEquals(new int[]{-55, -31, -2, 1, 8, 21, 21, 123}, result, () -> sortAlgorithm.getSortAlgorithmType().getName());
        });
    }
}
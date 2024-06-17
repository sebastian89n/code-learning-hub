package com.bastex.codelearninghub.algorithms.sorting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public abstract class SortAlgorithm {
    public int[] sortArray(final int[] intArray) {
        if (SortAlgorithmHelper.isEmptyOrHasOnlyOneElement(intArray)) {
            return intArray;
        }

        return sortWithAlgorithm(intArray);
    }

    protected abstract int[] sortWithAlgorithm(final int[] intArray);

    protected abstract SortAlgorithmType getSortAlgorithmType();

    @Getter
    @RequiredArgsConstructor
    public enum SortAlgorithmType {
        BUBBLE_SORT("Bubble Sort"),
        SELECTION_SORT("Selection Sort"),
        INSERTION_SORT("Insertion Sort"),
        SHELL_SORT("Shell Sort"),
        MERGE_SORT("Merge Sort"),
        ;

        private final String name;
    }
}

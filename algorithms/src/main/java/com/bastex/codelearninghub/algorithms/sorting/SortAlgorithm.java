package com.bastex.codelearninghub.algorithms.sorting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public abstract class SortAlgorithm {
    public int[] sortArray(final int[] input) {
        if (SortAlgorithmHelper.isEmptyOrHasOnlyOneElement(input)) {
            return input;
        }

        return sortWithAlgorithm(input);
    }

    protected abstract int[] sortWithAlgorithm(final int[] input);

    protected abstract SortAlgorithmType getSortAlgorithmType();

    @Getter
    @RequiredArgsConstructor
    public enum SortAlgorithmType {
        BUBBLE_SORT("Bubble Sort"),
        SELECTION_SORT("Selection Sort"),
        INSERTION_SORT("Insertion Sort"),
        SHELL_SORT("Shell Sort"),
        MERGE_SORT("Merge Sort"),
        QUICK_SORT("Quick Sort"),
        ;

        private final String name;
    }
}

package com.bastex.codelearninghub.algorithms.sorting;

public final class InsertionSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] input) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++) {
            final int elementToMove = input[firstUnsortedIndex];

            int newIndexForElementToMove;
            for (newIndexForElementToMove = firstUnsortedIndex; newIndexForElementToMove > 0 && input[newIndexForElementToMove - 1] > elementToMove; newIndexForElementToMove--) {
                input[newIndexForElementToMove] = input[newIndexForElementToMove - 1];
            }

            input[newIndexForElementToMove] = elementToMove;
        }

        return input;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.INSERTION_SORT;
    }
}

package com.bastex.codelearninghub.algorithms.sorting;

public final class InsertionSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] intArray) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            final int elementToMove = intArray[firstUnsortedIndex];

            int newIndexForElementToMove;
            for (newIndexForElementToMove = firstUnsortedIndex; newIndexForElementToMove > 0 && intArray[newIndexForElementToMove - 1] > elementToMove; newIndexForElementToMove--) {
                intArray[newIndexForElementToMove] = intArray[newIndexForElementToMove - 1];
            }

            intArray[newIndexForElementToMove] = elementToMove;
        }

        return intArray;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.INSERTION_SORT;
    }
}

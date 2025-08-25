package com.bastex.codelearninghub.algorithms.sorting;

public class SelectionSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] input) {

        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestElementIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (input[i] > input[largestElementIndex]) {
                    largestElementIndex = i;
                }
            }

            SortAlgorithmHelper.swapElementsByIndexes(input, largestElementIndex, lastUnsortedIndex);
        }

        return input;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.SELECTION_SORT;
    }
}

package com.bastex.codelearninghub.algorithms.sorting;

public class BubbleSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] input) {
        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            boolean isArrayAlreadySorted = true;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (input[i] > input[i + 1]) {
                    SortAlgorithmHelper.swapElementsByIndexes(input, i, i + 1);
                    isArrayAlreadySorted = false;
                }
            }

            if (isArrayAlreadySorted) {
                break;
            }
        }

        return input;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.BUBBLE_SORT;
    }
}

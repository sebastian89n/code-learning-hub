package com.bastex.codelearninghub.algorithms.sorting;

public class BubbleSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] intArray) {
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            boolean isArrayAlreadySorted = true;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    SortAlgorithmHelper.swapElementsByIndexes(intArray, i, i + 1);
                    isArrayAlreadySorted = false;
                }
            }

            if (isArrayAlreadySorted) {
                break;
            }
        }

        return intArray;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.BUBBLE_SORT;
    }
}

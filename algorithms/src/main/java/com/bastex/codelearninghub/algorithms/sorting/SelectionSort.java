package com.bastex.codelearninghub.algorithms.sorting;

public class SelectionSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] intArray) {

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestElementIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largestElementIndex]) {
                    largestElementIndex = i;
                }
            }

            SortAlgorithmHelper.swapElementsByIndexes(intArray, largestElementIndex, lastUnsortedIndex);
        }

        return intArray;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.SELECTION_SORT;
    }
}

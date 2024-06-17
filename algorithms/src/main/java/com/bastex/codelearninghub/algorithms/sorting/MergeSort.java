package com.bastex.codelearninghub.algorithms.sorting;

public class MergeSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] input) {
        mergeSort(input, 0, input.length);
        return input;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.MERGE_SORT;
    }

    private static void mergeSort(final int[] input, final int startIndex, final int endIndex) {
        if (SortAlgorithmHelper.isOneElementArrayBasedOnStartEndIndexes(startIndex, endIndex)) {
            return;
        }

        final int midIndex = (startIndex + endIndex) / 2;
        mergeSort(input, startIndex, midIndex);
        mergeSort(input, midIndex, endIndex);

        merge(input, startIndex, midIndex, endIndex);
    }

    private static void merge(final int[] input, final int startIndex, final int midIndex, final int endIndex) {
        // left array and right array are already sorted by itself
        final boolean areTwoHalvesOfArrayAlreadySorted = input[midIndex - 1] <= input[midIndex];
        if (areTwoHalvesOfArrayAlreadySorted) {
            return;
        }

        int i = startIndex;
        int j = midIndex;
        int tempIndex = 0;

        final int[] tempArray = new int[endIndex - startIndex];

        while (i < midIndex && j < endIndex) {
            tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // Optimization - copy any remaining elements from the left half of the array (if there are any)
        // The right half is already in place since it's already sorted.
        System.arraycopy(input, i, input, startIndex + tempIndex, midIndex - i);

        updateOriginalArrayWithSortedElements(input, startIndex, tempArray, tempIndex);
    }

    private static void updateOriginalArrayWithSortedElements(final int[] input, final int startIndex, final int[] tempArray, final int tempIndex) {
        System.arraycopy(tempArray, 0, input, startIndex, tempIndex);
    }
}

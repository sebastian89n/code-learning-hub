package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MergeSort {
    public static int[] sortArray(final int[] intArray) {
        if (SortingArraysHelper.isEmptyOrHasOnlyOneElement(intArray)) {
            return intArray;
        }

        mergeSort(intArray, 0, intArray.length);

        return intArray;
    }

    private static void mergeSort(final int[] input, final int startIndex, final int endIndex) {
        final boolean isOneElementArray = endIndex - startIndex <= 1;
        if (isOneElementArray) {
            return;
        }

        final int midIndex = (startIndex + endIndex) / 2;
        mergeSort(input, startIndex, midIndex);
        mergeSort(input, midIndex, endIndex);

        merge(input, startIndex, midIndex, endIndex);
    }

    private static void merge(final int[] input, final int startIndex, final int midIndex, final int endIndex) {
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

        // optimizes the merge process by handling the case where the left half of the array still has remaining elements after the right half has been exhausted.
        System.arraycopy(input, i, input, startIndex + tempIndex, midIndex - i);

        updateOriginalArrayWithSortedElements(input, startIndex, tempArray, tempIndex);
    }

    private static void updateOriginalArrayWithSortedElements(final int[] input, final int startIndex, final int[] tempArray, final int tempIndex) {
        System.arraycopy(tempArray, 0, input, startIndex, tempIndex);
    }
}

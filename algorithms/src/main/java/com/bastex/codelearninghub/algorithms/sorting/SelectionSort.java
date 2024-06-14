package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SelectionSort {
    public static int[] sortArray(final int[] intArray) {
        if (SortingAlgorithmsHelper.isArrayEmptyOrHasOnlyOneElement(intArray)) {
            return intArray;
        }

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestElementIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largestElementIndex]) {
                    largestElementIndex = i;
                }
            }

            SortingAlgorithmsHelper.swap(intArray, largestElementIndex, lastUnsortedIndex);
        }

        return intArray;
    }
}

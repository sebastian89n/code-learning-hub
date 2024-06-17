package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class SortAlgorithmHelper {
    static void swapElementsByIndexes(final int[] intArray, final int i, final int j) {
        if (i == j) {
            return;
        }

        final int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }

    static boolean isEmptyOrHasOnlyOneElement(final int[] intArray) {
        return intArray == null || intArray.length == 0 || intArray.length == 1;
    }
}

package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RadixSort {
    public static int[] radixSort(final int[] input) {
        if (SortAlgorithmHelper.isEmptyOrHasOnlyOneElement(input)) {
            return input;
        }

        return input;
    }
}

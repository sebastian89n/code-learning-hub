package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MergeSort {
    public static int[] sortArray(final int[] intArray) {
        if (SortingArraysHelper.isEmptyOrHasOnlyOneElement(intArray)) {
            return intArray;
        }

        return intArray;
    }
}

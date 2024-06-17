package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class SortAlgorithmHelper {
    static void swapElementsByIndexes(final int[] input, final int i, final int j) {
        if (i == j) {
            return;
        }

        final int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    static boolean isEmptyOrHasOnlyOneElement(final int[] input) {
        return input == null || input.length == 0 || input.length == 1;
    }

    static boolean isOneElementArrayBasedOnStartEndIndexes(final int startIndex, final int endIndex) {
        return endIndex - startIndex <= 1;
    }
}

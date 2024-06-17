package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CountingSort {
    public static int[] countingSort(final int[] input, final int min, final int max) {
        if (SortAlgorithmHelper.isEmptyOrHasOnlyOneElement(input)) {
            return input;
        }

        final int[] countArray = new int[max - min + 1];

        populateCountArrayWithData(input, min, countArray);
        overrideInputArray(input, min, countArray);

        return input;
    }

    private static void populateCountArrayWithData(final int[] input, final int min, final int[] countArray) {
        for (final int num : input) {
            countArray[num - min]++;
        }
    }

    private static void overrideInputArray(final int[] input, final int min, final int[] countArray) {
        int currentIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                input[currentIndex++] = i + min;
                countArray[i]--;
            }
        }
    }
}

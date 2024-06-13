package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BubbleSort {
    public static int[] sortArray(int[] intArray) {
        if (intArray == null || intArray.length == 0) {
            return intArray;
        }

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            boolean isArrayAlreadySorted = true;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                    isArrayAlreadySorted = false;
                }
            }

            if (isArrayAlreadySorted) {
                break;
            }
        }

        return intArray;
    }

    private static void swap(int[] intArray, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }
}

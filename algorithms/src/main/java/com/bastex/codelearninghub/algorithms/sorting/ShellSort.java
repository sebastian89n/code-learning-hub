package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShellSort {
    public static int[] sortArray(final int[] intArray) {
        if (SortingArraysHelper.isEmptyOrHasOnlyOneElement(intArray)) {
            return intArray;
        }

        // There are different ways and methods on how to calculate and select gap
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                final int elementToMove = intArray[i];

                int newIndexForElementToMove = i;
                while (newIndexForElementToMove >= gap && intArray[newIndexForElementToMove - gap] > elementToMove) {
                    intArray[newIndexForElementToMove] = intArray[newIndexForElementToMove - gap];
                    newIndexForElementToMove -= gap;
                }

                intArray[newIndexForElementToMove] = elementToMove;
            }
        }

        return intArray;
    }
}

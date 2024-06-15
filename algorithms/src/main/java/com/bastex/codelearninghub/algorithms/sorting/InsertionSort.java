package com.bastex.codelearninghub.algorithms.sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsertionSort {
    public static int[] sortArray(final int[] intArray) {
        if (SortingArraysHelper.isEmptyOrHasOnlyOneElement(intArray)) {
            return intArray;
        }

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            final int elementToMove = intArray[firstUnsortedIndex];

            int newIndexForElementToMove;
            for (newIndexForElementToMove = firstUnsortedIndex; newIndexForElementToMove > 0 && intArray[newIndexForElementToMove - 1] > elementToMove; newIndexForElementToMove--) {
                intArray[newIndexForElementToMove] = intArray[newIndexForElementToMove - 1];
            }

            intArray[newIndexForElementToMove] = elementToMove;
        }

        return intArray;
    }
}

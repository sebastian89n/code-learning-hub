package com.bastex.codelearninghub.algorithms.sorting;

public class ShellSort extends SortAlgorithm {
    protected int[] sortWithAlgorithm(final int[] input) {
        if (SortAlgorithmHelper.isEmptyOrHasOnlyOneElement(input)) {
            return input;
        }

        // There are different ways and methods on how to calculate and select gap
        for (int gap = input.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < input.length; i++) {
                final int elementToMove = input[i];

                int newIndexForElementToMove = i;
                while (newIndexForElementToMove >= gap && input[newIndexForElementToMove - gap] > elementToMove) {
                    input[newIndexForElementToMove] = input[newIndexForElementToMove - gap];
                    newIndexForElementToMove -= gap;
                }

                input[newIndexForElementToMove] = elementToMove;
            }
        }

        return input;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.SHELL_SORT;
    }
}

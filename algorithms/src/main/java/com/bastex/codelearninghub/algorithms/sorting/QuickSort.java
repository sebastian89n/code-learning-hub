package com.bastex.codelearninghub.algorithms.sorting;

public class QuickSort extends SortAlgorithm {
    @Override
    protected int[] sortWithAlgorithm(final int[] input) {
        quickSort(input, 0, input.length);
        return input;
    }

    @Override
    protected SortAlgorithmType getSortAlgorithmType() {
        return SortAlgorithmType.QUICK_SORT;
    }

    private static void quickSort(final int[] input, final int start, final int end) {
        if (SortAlgorithmHelper.isOneElementArrayBasedOnStartEndIndexes(start, end)) {
            return;
        }

        final int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    // TODO refactor
    private static int partition(final int[] input, final int start, final int end) {
        // This implementation uses first element as the pivot
        final int pivot = input[start];
        int leftIndex = start;
        int rightIndex = end;

        while (leftIndex < rightIndex) {
            rightIndex = findFirstElementLessThanPivotFromRight(input, leftIndex, --rightIndex, pivot);

            if (leftIndex < rightIndex) {
                input[leftIndex] = input[rightIndex];
            }

            leftIndex = findFirstElementGreaterThanPivotFromLeft(input, ++leftIndex, rightIndex, pivot);

            if (leftIndex < rightIndex) {
                input[rightIndex] = input[leftIndex];
            }
        }

        input[rightIndex] = pivot;
        return rightIndex;
    }

    private static int findFirstElementGreaterThanPivotFromLeft(final int[] input, int leftIndex, final int rightIndex, final int pivot) {
        while (leftIndex < rightIndex && input[leftIndex] <= pivot) {
            leftIndex++;
        }

        return leftIndex;
    }

    private static int findFirstElementLessThanPivotFromRight(final int[] input, final int leftIndex, int rightIndex, final int pivot) {
        while (leftIndex < rightIndex && input[rightIndex] >= pivot) {
            rightIndex--;
        }

        return rightIndex;
    }
}

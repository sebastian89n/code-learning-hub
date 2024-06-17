package com.bastex.codelearninghub.datastructures.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArraysInJavaTester {
    public static void main(final String[] args) {
        // static size
        final int[] input = new int[7];

        input[0] = 20;
        input[1] = 35;
        input[2] = -15;
        input[3] = 7;
        input[4] = 55;
        input[5] = 1;
        // not specifying value at index 6. In Java default values are 0 for numeric, false for boolean, nulls for objects
        // input[6] = -22;

        int index = -1;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 7) {
                index = i;
            }
        }

        log.info("Index: {}", index);
    }
}

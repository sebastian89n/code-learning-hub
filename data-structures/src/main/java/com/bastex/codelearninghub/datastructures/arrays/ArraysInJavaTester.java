package com.bastex.codelearninghub.datastructures.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArraysInJavaTester {
    public static void main(final String[] args) {
        // static size
        final int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        // not specifying value at index 6. In Java default values are 0 for numeric, false for boolean, nulls for objects
        // intArray[6] = -22;

        int index = -1;

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 7) {
                index = i;
            }
        }

        log.info("Index: {}", index);
    }
}

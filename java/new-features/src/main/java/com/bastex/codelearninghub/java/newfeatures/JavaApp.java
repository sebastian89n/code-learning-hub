package com.bastex.codelearninghub.java.newfeatures;

import com.bastex.codelearninghub.java.newfeatures.java10.Java10Tester;
import com.bastex.codelearninghub.java.newfeatures.java11.Java11Tester;
import com.bastex.codelearninghub.java.newfeatures.java17.Java17Tester;
import com.bastex.codelearninghub.java.newfeatures.java21.Java21Tester;
import com.bastex.codelearninghub.java.newfeatures.java9.Java9Tester;

public class JavaApp {
    public static void main(final String[] args) {
        Java9Tester.testJava9Features();
        Java10Tester.testJava10Features();
        Java11Tester.testJava11Features();
        Java17Tester.testJava17Features();
        Java21Tester.testJava21Features();
    }
}

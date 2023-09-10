package com.bastex.codelearninghub.designpatterns.structural.flyweight;


public class FlyWeightApp {
    public static void main(final String[] args) {
        final WordProcessor processor = new WordProcessor();

        final String textToAdd = "Hello i'm aaaa wwworddd pprocessorrrr";
        final int length = textToAdd.length();

        final LetterFactory factory = new LetterFactory();
        for (int i = 0; i < length; i++) {
            final String value = textToAdd.substring(i, i + 1);
            processor.addLetter(factory.createLetter(value));
        }

        processor.printLetters();
    }


}

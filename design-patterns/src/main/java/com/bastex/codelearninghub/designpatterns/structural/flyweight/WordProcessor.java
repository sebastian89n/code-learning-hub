package com.bastex.codelearninghub.designpatterns.structural.flyweight;


import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private final List<Letter> letters = new ArrayList<>();

    public void addLetter(final Letter letter) {
        this.letters.add(letter);
    }

    public void printLetters() {
        for (final Letter letter : letters) {
            System.out.print(letter.getValue());
        }
        System.out.println();
    }

}

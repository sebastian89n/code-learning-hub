package com.bastex.codelearninghub.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    private final Map<String, Letter> letterMap = new HashMap<>();

    public Letter createLetter(final String key) {
        Letter letter = letterMap.get(key);
        if (letter == null) {
            letter = new Letter(key);
            letterMap.put(key, letter);
        }

        return letter;
    }
}

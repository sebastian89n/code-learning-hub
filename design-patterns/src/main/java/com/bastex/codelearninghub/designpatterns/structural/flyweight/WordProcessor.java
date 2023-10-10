package com.bastex.codelearninghub.designpatterns.structural.flyweight;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class WordProcessor {
    private final List<Letter> letters = new ArrayList<>();

    public void addLetter(final Letter letter) {
        this.letters.add(letter);
    }

    public void printLetters() {
        final String aggregated = letters.stream().map(Letter::getValue).collect(Collectors.joining());
        log.info(aggregated);
    }

}

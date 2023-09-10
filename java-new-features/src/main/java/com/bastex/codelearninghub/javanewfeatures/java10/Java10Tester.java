package com.bastex.codelearninghub.javanewfeatures.java10;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Java10Tester {
    public static void testJava10Features() {
        // var keyword - type inference
        var firstName = "John";
        firstName = "Johnny";

        final var age = 35;

        // New methods new Collectors for unmodifiable collections
        final List<String> unmodifiableList = Stream.of("123", "321").collect(Collectors.toUnmodifiableList());
        final Set<String> unmodifiableSet = Stream.of("123", "321").collect(Collectors.toUnmodifiableSet());

        final Map<String, Integer> unmodifiableMap = Map.of("key1", 10, "key2", 20).entrySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

        
    }
}

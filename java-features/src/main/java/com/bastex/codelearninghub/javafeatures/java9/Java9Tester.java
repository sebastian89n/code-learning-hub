package com.bastex.codelearninghub.javafeatures.java9;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Java9Tester {
    public static void testJava9Features() {
        // Convenience Factory Methods for Collections
        final Set<String> immutableSet = Set.of("test1", "test2", "test3");
        final List<String> immutableList = List.of("test1", "test2", "test3");
        final Map<String, Integer> immutableMap = Map.of("key1", 10, "key2", 20, "key3", 30);
        final Map<String, Integer> immutableMap2 = Map.ofEntries(Map.entry("key1", 10), Map.entry("key2", 20), Map.entry("key3", 30));

        // Additionally:
        // JShell - a dedicated REPL (Read-Eval-Print-Loop) in JDK
        // G1 as default garbage collector
        // StackWalking API - https://www.baeldung.com/java-9-stackwalking-api
        // Java modules
    }
}

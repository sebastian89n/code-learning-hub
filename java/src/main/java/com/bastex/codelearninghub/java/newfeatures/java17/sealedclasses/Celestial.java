package com.bastex.codelearninghub.java.newfeatures.java17.sealedclasses;

// sealed can be also applied on the interfaces
public sealed interface Celestial {
    final class Planet implements Celestial {
    }

    final class Star implements Celestial {
    }

    non-sealed class Comet implements Celestial {
    }
}

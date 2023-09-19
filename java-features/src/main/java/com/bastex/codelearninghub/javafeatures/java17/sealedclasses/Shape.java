package com.bastex.codelearninghub.javafeatures.java17.sealedclasses;

// Sealed class must contain subclasses
// if subclasses are contained directly within sealed class we don't need to specify them with permits
public abstract sealed class Shape {

    // extending class can be final -> cannot be further extended
    public static final class Triangle extends Shape {

    }

    // extending class can be another sealed class
    // this time we need permits because permitted classes are outside sealed class
    public static abstract sealed class Rectangle extends Shape permits RectangleFilled, RectangleTransparent {

    }

    // allows open extension by another classes
    public static non-sealed class CustomShape extends Shape {

    }
}

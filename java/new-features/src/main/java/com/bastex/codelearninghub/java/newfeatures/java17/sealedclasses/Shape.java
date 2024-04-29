package com.bastex.codelearninghub.java.newfeatures.java17.sealedclasses;

/**
 * Sealed class must contain subclasses
 * if subclasses are contained directly within sealed class we don't need to specify them with permits
 * extending classes must be explicitly marked as either final, non-sealed or sealed.
 */
public abstract sealed class Shape {

    // extending class can be final -> cannot be further extended
    public static final class Triangle extends Shape {

    }

    // extending class can be another sealed class
    // this time we need permits because permitted classes are outside sealed class
    // permitted classes must be located within the same class or package
    public static abstract sealed class Rectangle extends Shape permits RectangleFilled, RectangleTransparent {

    }

    // allows open extension by another classes
    public static non-sealed class CustomShape extends Shape {

    }
}

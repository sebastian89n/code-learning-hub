package com.bastex.codelearninghub.designpatterns.structural.adapter;

public class AdapterApp {

    public static void main(final String[] args) {
        final LegacyRectangle legacyRectangle = new LegacyRectangle();
        final LegacyRectangleAdapter adapter = new LegacyRectangleAdapter(legacyRectangle);

        calculateRectangleSize(adapter);
    }


    private static void calculateRectangleSize(final Rectangle rectangle) {
        System.out.println("Rectangle Size: " + rectangle.determineSize());
    }
}


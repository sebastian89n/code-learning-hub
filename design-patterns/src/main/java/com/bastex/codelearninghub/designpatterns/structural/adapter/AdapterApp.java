package com.bastex.codelearninghub.designpatterns.structural.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdapterApp {
    public static void main(final String[] args) {
        final LegacyRectangle legacyRectangle = new LegacyRectangle();
        final LegacyRectangleAdapter adapter = new LegacyRectangleAdapter(legacyRectangle);

        calculateRectangleSize(adapter);
    }

    private static void calculateRectangleSize(final Rectangle rectangle) {
        log.info("Rectangle Size: {}", rectangle.determineSize());
    }
}


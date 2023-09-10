package com.bastex.codelearninghub.designpatterns.structural.adapter;

public class LegacyRectangleAdapter extends Rectangle {

    private final LegacyRectangle legacyRectangle;

    public LegacyRectangleAdapter(final LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public Integer determineSize() {
        return legacyRectangle.calculateSize();
    }
}

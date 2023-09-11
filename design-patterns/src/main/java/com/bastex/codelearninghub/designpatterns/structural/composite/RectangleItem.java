package com.bastex.codelearninghub.designpatterns.structural.composite;

public class RectangleItem implements GraphicItem {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

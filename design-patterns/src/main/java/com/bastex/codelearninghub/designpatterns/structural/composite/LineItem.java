package com.bastex.codelearninghub.designpatterns.structural.composite;


public class LineItem implements GraphicItem {
    @Override
    public void draw() {
        System.out.println("Draw line");
    }
}

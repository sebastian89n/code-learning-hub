package com.bastex.codelearninghub.designpatterns.structural.decorator;


public class IconWindowDecorator extends WindowDecorator {
    public IconWindowDecorator(final Window window) {
        super(window);
    }

    @Override
    public void draw() {
        System.out.println("Drawing icon");
        window.draw();
    }
}

package com.bastex.codelearninghub.designpatterns.structural.decorator;


public class ScrollbarWindowDecorator extends WindowDecorator {
    public ScrollbarWindowDecorator(final Window window) {
        super(window);
    }

    @Override
    public void draw() {
        System.out.println("Draw a scrollbar");
        window.draw();
    }
}

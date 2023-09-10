package com.bastex.codelearninghub.designpatterns.structural.decorator;


public class WindowDecorator extends Window {
    protected Window window;

    public WindowDecorator(final Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();
    }
}

package com.bastex.codelearninghub.designpatterns.structural.decorator;

public class DecoratorApp {

    public static void main(final String[] args) {
        final Window window = new Window();
        final IconWindowDecorator iconWindowDecorator = new IconWindowDecorator(window);
        final ScrollbarWindowDecorator scrollbarWindowDecorator = new ScrollbarWindowDecorator(iconWindowDecorator);

        scrollbarWindowDecorator.draw();
    }
}

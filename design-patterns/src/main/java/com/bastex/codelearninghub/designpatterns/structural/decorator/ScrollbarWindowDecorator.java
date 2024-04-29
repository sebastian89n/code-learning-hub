package com.bastex.codelearninghub.designpatterns.structural.decorator;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScrollbarWindowDecorator extends WindowDecorator {
    public ScrollbarWindowDecorator(final Window window) {
        super(window);
    }

    @Override
    public void draw() {
        log.info("Draw a scrollbar");
        window.draw();
    }
}

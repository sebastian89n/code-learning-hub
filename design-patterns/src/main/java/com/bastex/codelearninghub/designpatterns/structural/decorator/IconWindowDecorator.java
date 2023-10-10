package com.bastex.codelearninghub.designpatterns.structural.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IconWindowDecorator extends WindowDecorator {
    public IconWindowDecorator(final Window window) {
        super(window);
    }

    @Override
    public void draw() {
        log.info("Drawing icon");
        window.draw();
    }
}

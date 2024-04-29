package com.bastex.codelearninghub.designpatterns.structural.composite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RectangleItem implements GraphicItem {
    @Override
    public void draw() {
        log.info("Drawing a rectangle");
    }
}

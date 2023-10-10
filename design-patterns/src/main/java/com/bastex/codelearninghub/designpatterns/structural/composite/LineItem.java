package com.bastex.codelearninghub.designpatterns.structural.composite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LineItem implements GraphicItem {
    @Override
    public void draw() {
        log.info("Draw line");
    }
}

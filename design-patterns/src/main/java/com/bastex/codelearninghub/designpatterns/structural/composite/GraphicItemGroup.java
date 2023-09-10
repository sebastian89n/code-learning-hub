package com.bastex.codelearninghub.designpatterns.structural.composite;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GraphicItemGroup implements Graphic {

    @Getter
    private final List<Graphic> graphics = new ArrayList<>();

    @Override
    public void draw() {
        for (final Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

package com.bastex.codelearninghub.designpatterns.structural.composite;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GraphicItemGroup implements GraphicItem {
    @Getter
    private final List<GraphicItem> graphicItems = new ArrayList<>();

    @Override
    public void draw() {
        for (final GraphicItem graphicItem : graphicItems) {
            graphicItem.draw();
        }
    }
}

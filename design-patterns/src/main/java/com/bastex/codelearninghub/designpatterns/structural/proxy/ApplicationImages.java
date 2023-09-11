package com.bastex.codelearninghub.designpatterns.structural.proxy;


import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ApplicationImages {
    private final List<Image> images;

    public void draw() {
        for (final Image image : images) {
            image.draw();
        }
    }
}

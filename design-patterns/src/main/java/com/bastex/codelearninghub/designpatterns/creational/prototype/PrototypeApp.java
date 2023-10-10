package com.bastex.codelearninghub.designpatterns.creational.prototype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeApp {

    public static void main(final String[] args) {
        final Image image = new Image();
        image.setUrl("http://test.com");

        final GraphicTool tool = new GraphicTool(image);

        Graphic graphic = tool.createGraphic();

        log.info("Graphic instance {}", graphic.getClass());
        log.info("Graphic url {}", graphic.getUrl());

        image.setUrl("test");

        graphic = tool.createGraphic();
        log.info("Graphic url {}", graphic.getUrl());

        final Video video = new Video();
        video.setUrl("http://test.video.com");

        tool.setPrototype(video);

        graphic = tool.createGraphic();

        log.info("Graphic instance {}", graphic.getClass());
        log.info("Graphic url {}", graphic.getUrl());


    }

}

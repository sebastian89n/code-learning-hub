package com.bastex.codelearninghub.designpatterns.creational.prototype;

public class PrototypeApp {

    public static void main(final String[] args) {
        final Image image = new Image();
        image.setUrl("http://test.com");

        final GraphicTool tool = new GraphicTool(image);

        Graphic graphic = tool.createGraphic();

        System.out.println("Graphic instance " + graphic.getClass());
        System.out.println("Graphic url " + graphic.getUrl());

        image.setUrl("test");

        graphic = tool.createGraphic();
        System.out.println("Graphic url " + graphic.getUrl());

        final Video video = new Video();
        video.setUrl("http://test.video.com");

        tool.setPrototype(video);

        graphic = tool.createGraphic();

        System.out.println("Graphic instance " + graphic.getClass());
        System.out.println("Graphic url " + graphic.getUrl());


    }

}

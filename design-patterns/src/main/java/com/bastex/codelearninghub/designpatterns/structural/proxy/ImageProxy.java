package com.bastex.codelearninghub.designpatterns.structural.proxy;


public class ImageProxy extends Image {

    private Image image;

    public ImageProxy(final String url) {
        super();
        this.url = url;
    }

    @Override
    public void draw() {
        if (image == null) {
            image = new Image(this.url);
        }
        image.draw();
    }
}

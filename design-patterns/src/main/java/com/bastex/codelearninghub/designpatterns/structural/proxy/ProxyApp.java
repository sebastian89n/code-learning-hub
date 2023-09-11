package com.bastex.codelearninghub.designpatterns.structural.proxy;


import java.util.List;

public class ProxyApp {
    public static void main(final String[] args) {
        final ImageProxy image = new ImageProxy("test image");
        final ImageProxy image2 = new ImageProxy("second image");

        final ApplicationImages application = new ApplicationImages(List.of(image, image2));

        System.out.println("Application setup");
        application.draw();
    }
}

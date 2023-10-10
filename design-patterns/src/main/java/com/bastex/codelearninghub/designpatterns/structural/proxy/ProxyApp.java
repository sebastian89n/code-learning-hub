package com.bastex.codelearninghub.designpatterns.structural.proxy;


import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProxyApp {
    public static void main(final String[] args) {
        final ImageProxy image = new ImageProxy("test image");
        final ImageProxy image2 = new ImageProxy("second image");

        final ApplicationImages application = new ApplicationImages(List.of(image, image2));

        log.info("Application setup");
        application.draw();
    }
}

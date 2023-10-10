package com.bastex.codelearninghub.designpatterns.structural.proxy;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class Image {
    protected String url;

    public Image(final String url) {
        log.info("Loading image");
        this.url = url;
    }

    public void draw() {
        log.info("Draw image from url {}", url);
    }

}

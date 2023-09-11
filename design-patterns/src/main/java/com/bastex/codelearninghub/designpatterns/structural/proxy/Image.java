package com.bastex.codelearninghub.designpatterns.structural.proxy;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Image {
    protected String url;

    public Image(final String url) {
        System.out.println("Loading image");
        this.url = url;
    }

    public void draw() {
        System.out.println("Draw image from url " + url);
    }

}

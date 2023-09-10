package com.bastex.codelearninghub.designpatterns.structural.composite;


public class Line implements Graphic {
    @Override
    public void draw() {
        System.out.println("Draw line");
    }
}

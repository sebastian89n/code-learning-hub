package com.bastex.codelearninghub.designpatterns.creational.prototype;

public abstract class Graphic {
    @Override
    public abstract Graphic clone();

    public abstract String getUrl();
}

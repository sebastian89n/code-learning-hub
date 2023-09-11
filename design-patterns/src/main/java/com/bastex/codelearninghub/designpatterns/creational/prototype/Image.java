package com.bastex.codelearninghub.designpatterns.creational.prototype;

public class Image extends Graphic {
    private String url;

    @Override
    public Graphic clone() {
        // create new clone
        final Image clone = new Image();
        clone.setUrl(this.url);
        return clone;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}

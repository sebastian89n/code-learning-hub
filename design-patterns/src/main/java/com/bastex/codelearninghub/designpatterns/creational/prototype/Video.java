package com.bastex.codelearninghub.designpatterns.creational.prototype;

import lombok.Getter;
import lombok.Setter;

public class Video extends Graphic {

    @Getter
    @Setter
    private String url;

    @Override
    public Graphic clone() {
        final Video clone = new Video();
        clone.setUrl(this.url);
        return clone;
    }

}

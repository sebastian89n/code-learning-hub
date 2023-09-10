package com.bastex.codelearninghub.designpatterns.behavioral.observer;


public class ItemList implements Observer {
    public void setListValue(final int value) {
        System.out.println("Set list value : " + value);
    }

    @Override
    public void update() {
        setListValue(1);
    }
}

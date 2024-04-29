package com.bastex.codelearninghub.designpatterns.behavioral.observer;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemList implements Observer {
    public void setListValue(final int value) {
        log.info("Set list value : {}", value);
    }

    @Override
    public void update() {
        setListValue(1);
    }
}

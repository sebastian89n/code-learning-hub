package com.bastex.codelearninghub.designpatterns.behavioral.observer;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputText implements Observer {
    public void setText(final String text) {
        log.info("Inputtext set text: {}", text);
    }

    @Override
    public void update() {
        this.setText("button has been clicked");
    }
}

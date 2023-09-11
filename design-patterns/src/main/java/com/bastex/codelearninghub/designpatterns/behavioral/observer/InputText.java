package com.bastex.codelearninghub.designpatterns.behavioral.observer;


public class InputText implements Observer {
    public void setText(final String text) {
        System.out.println("Inputtext set text: " + text);
    }

    @Override
    public void update() {
        this.setText("button has been clicked");
    }
}

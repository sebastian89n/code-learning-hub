package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


public interface ScreenDirector {
    void itemSelected(String item);

    String getSelectedItem();
}

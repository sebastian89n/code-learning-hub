package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


import lombok.Setter;

public class ScreenDirectorOne implements Screendirector {
    @Setter
    private InputText inputText;

    @Override
    public void itemSelected(final String item) {
        inputText.setValue(item);
    }
}

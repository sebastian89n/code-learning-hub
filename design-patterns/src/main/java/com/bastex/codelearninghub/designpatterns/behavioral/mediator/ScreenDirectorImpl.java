package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


public class ScreenDirectorImpl implements ScreenDirector {
    private String selectedItem;

    @Override
    public void itemSelected(final String selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public String getSelectedItem() {
        return selectedItem;
    }
}

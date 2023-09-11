package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


public class MediatorApp {
    public static void main(final String[] args) {
        final ScreenDirector screenDirector = new ScreenDirectorImpl();

        final ItemList itemList = new ItemList();
        itemList.setScreendirector(screenDirector);

        itemList.getItems().add("Data item one");
        itemList.getItems().add("Data item two");
        itemList.getItems().add("Data item three");

        itemList.selectItem(2);
        System.out.println("Selected value is: " + screenDirector.getSelectedItem());
    }
}

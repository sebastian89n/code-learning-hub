package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


public class MediatorApp {
    public static void main(final String[] args) {
        final InputText inputText = new InputText();

        final ScreenDirectorOne screendirector = new ScreenDirectorOne();
        screendirector.setInputText(inputText);

        final ItemList itemList = new ItemList();
        itemList.setScreendirector(screendirector);

        itemList.getItems().add("Data item one");
        itemList.getItems().add("Data item two");
        itemList.getItems().add("Data item three");

        itemList.selectItem(2);
        System.out.println("Selected value is: " + inputText.getValue());
    }
}

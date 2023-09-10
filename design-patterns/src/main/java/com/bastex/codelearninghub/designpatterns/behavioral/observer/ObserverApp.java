package com.bastex.codelearninghub.designpatterns.behavioral.observer;


public class ObserverApp {
    public static void main(final String[] args) {
        final InputText text = new InputText();
        final ItemList itemList = new ItemList();

        final Button button = new Button();
        button.attachObserver(text);
        button.attachObserver(itemList);
        button.clicked();
    }
}

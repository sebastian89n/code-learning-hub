package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediatorApp {
    public static void main(final String[] args) {
        final ScreenDirector screenDirector = new ScreenDirectorImpl();

        final ItemList itemList = new ItemList(screenDirector);

        itemList.getItems().add("Data item one");
        itemList.getItems().add("Data item two");
        itemList.getItems().add("Data item three");

        itemList.selectItem(2);
        log.info("Selected value is: {}", screenDirector.getSelectedItem());
    }
}

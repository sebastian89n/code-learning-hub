package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ItemList {
    @Getter
    private final List<String> items = new ArrayList<>();

    private final ScreenDirector screendirector;


    public void selectItem(final int itemNumber) {
        final String item = items.get(itemNumber);
        if (screendirector != null) {
            screendirector.itemSelected(item);
        }
    }
}

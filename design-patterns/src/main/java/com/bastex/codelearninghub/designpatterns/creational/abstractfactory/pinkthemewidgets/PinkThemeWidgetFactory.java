package com.bastex.codelearninghub.designpatterns.creational.abstractfactory.pinkthemewidgets;

import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.ScrollBar;
import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.WidgetFactory;
import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.Window;

public class PinkThemeWidgetFactory implements WidgetFactory {
    @Override
    public ScrollBar createScrollBar() {
        return new PinkThemeScrollBar();
    }

    @Override
    public Window createWindow() {
        return new PinkThemeWindow();
    }
}

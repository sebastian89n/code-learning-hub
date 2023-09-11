package com.bastex.codelearninghub.designpatterns.creational.abstractfactory;

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

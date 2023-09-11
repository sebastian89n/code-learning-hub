package com.bastex.codelearninghub.designpatterns.creational.abstractfactory;

public class YellowThemeWidgetFactory implements WidgetFactory {
    @Override
    public ScrollBar createScrollBar() {
        return new YellowThemeScrollbar();
    }

    @Override
    public Window createWindow() {
        return new YellowThemeWindow();
    }
}

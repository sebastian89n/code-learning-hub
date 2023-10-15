package com.bastex.codelearninghub.designpatterns.creational.abstractfactory.yellowthemewidgets;

import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.ScrollBar;
import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.WidgetFactory;
import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.Window;

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

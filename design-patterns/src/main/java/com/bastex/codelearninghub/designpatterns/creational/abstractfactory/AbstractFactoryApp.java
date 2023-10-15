package com.bastex.codelearninghub.designpatterns.creational.abstractfactory;

import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.pinkthemewidgets.PinkThemeWidgetFactory;
import com.bastex.codelearninghub.designpatterns.creational.abstractfactory.yellowthemewidgets.YellowThemeWidgetFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractFactoryApp {
    public static void main(final String[] args) {
        final WidgetFactory pinkThemeWidgetFactory = new PinkThemeWidgetFactory();
        initializeGUI(pinkThemeWidgetFactory);

        final WidgetFactory yellowThemeWidgetFactory = new YellowThemeWidgetFactory();
        initializeGUI(yellowThemeWidgetFactory);
    }

    private static void initializeGUI(final WidgetFactory factory) {
        initializeGUI(factory.createScrollBar(), factory.createWindow());
    }

    private static void initializeGUI(final ScrollBar bar, final Window window) {
        log.info("Do initialization logic here with {} and {}", bar.getClass().getName(), window.getClass().getName());
    }
}

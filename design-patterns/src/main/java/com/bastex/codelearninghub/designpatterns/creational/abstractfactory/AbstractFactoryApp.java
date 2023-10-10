package com.bastex.codelearninghub.designpatterns.creational.abstractfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractFactoryApp {
    public static void main(final String[] args) {
        WidgetFactory factory = new PinkThemeWidgetFactory();
        initializeGUI(factory);

        factory = new YellowThemeWidgetFactory();
        initializeGUI(factory);
    }

    private static void initializeGUI(final WidgetFactory factory) {
        initializeGUI(factory.createScrollBar(), factory.createWindow());
    }

    private static void initializeGUI(final ScrollBar bar, final Window window) {
        log.info("Do initialization logic here with {} and {}", bar.getClass().getName(), window.getClass().getName());
    }
}

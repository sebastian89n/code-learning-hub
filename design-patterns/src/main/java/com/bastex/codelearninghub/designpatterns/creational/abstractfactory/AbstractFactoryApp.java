package com.bastex.codelearninghub.designpatterns.creational.abstractfactory;

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
        System.out.println("Do initazation logic here with " + bar.getClass().getName() + " and " + window.getClass().getName());
    }
}

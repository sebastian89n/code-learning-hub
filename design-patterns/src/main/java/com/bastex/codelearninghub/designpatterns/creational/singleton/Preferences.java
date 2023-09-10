package com.bastex.codelearninghub.designpatterns.creational.singleton;

// one of the example implementations
// other one is enum, synchronized block (double check) etc.
public class Preferences {

    private static Preferences instance = null;

    private Preferences() {
    }

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new Preferences();
        }
    }

    public static Preferences getInstance() {
        if (instance == null) {
            createInstance();
        }

        return instance;
    }
}

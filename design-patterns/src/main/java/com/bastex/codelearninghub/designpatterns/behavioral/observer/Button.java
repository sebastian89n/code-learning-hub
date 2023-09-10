package com.bastex.codelearninghub.designpatterns.behavioral.observer;


import java.util.ArrayList;
import java.util.List;

public class Button implements Subject {
    private final List<Observer> observers = new ArrayList<Observer>();

    public void clicked() {
        change();
    }

    @Override
    public void attachObserver(final Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(final Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void change() {
        for (final Observer observer : observers) {
            observer.update();
        }
    }
}

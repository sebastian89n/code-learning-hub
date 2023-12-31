package com.bastex.codelearninghub.designpatterns.behavioral.observer;


public interface Subject {
    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObservers();

}

package com.bastex.codelearninghub.designpatterns.behavioral.visitor;

public class VisitorApp {

    public static void main(final String[] args) {

        final Car car = new Car();

        car.addCarPart(new Wheel());
        car.addCarPart(new Wheel());
        car.addCarPart(new Wheel());
        car.addCarPart(new Wheel());

        car.addCarPart(new Light());
        car.addCarPart(new Light());

        car.addCarPart(new Engine());

        car.upgrade();

        car.print();
        car.render();
    }
}

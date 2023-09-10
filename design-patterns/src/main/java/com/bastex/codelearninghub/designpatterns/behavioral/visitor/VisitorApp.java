package com.bastex.codelearninghub.designpatterns.behavioral.visitor;

public class VisitorApp {

    public static void main(final String[] args) {

        final Car car = new Car();

        car.getCarParts().add(new Wheel());
        car.getCarParts().add(new Wheel());
        car.getCarParts().add(new Wheel());
        car.getCarParts().add(new Wheel());

        car.getCarParts().add(new Light());
        car.getCarParts().add(new Light());

        car.getCarParts().add(new Engine());


        car.upgrade();

        car.print();
        car.render();
    }
}

package com.bastex.codelearninghub.designpatterns.creational.factorymethod;


public class FactoryMethodApp {
    public static void main(final String[] args) {
        TransportFactory factory = new BikeFactory();
        Transport transport = factory.create();

        System.out.println(transport.drive());

        factory = new CarFactory();
        transport = factory.create();

        System.out.println(transport.drive());
    }
}

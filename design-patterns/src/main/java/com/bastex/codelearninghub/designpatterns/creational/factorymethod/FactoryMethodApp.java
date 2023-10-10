package com.bastex.codelearninghub.designpatterns.creational.factorymethod;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryMethodApp {
    public static void main(final String[] args) {
        TransportFactory factory = new BikeFactory();
        Transport transport = factory.create();

        log.info(transport.drive());

        factory = new CarFactory();
        transport = factory.create();

        log.info(transport.drive());
    }
}

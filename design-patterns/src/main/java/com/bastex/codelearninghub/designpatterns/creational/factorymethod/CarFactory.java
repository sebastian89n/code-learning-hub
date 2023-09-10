package com.bastex.codelearninghub.designpatterns.creational.factorymethod;

public class CarFactory extends TransportFactory {
    @Override
	Transport create() {
        return new Car();
    }
}

package com.bastex.codelearninghub.designpatterns.behavioral.visitor;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private final List<CarPart> carParts = new ArrayList<>();

    public void addCarPart(final CarPart carPart) {
        carParts.add(carPart);
    }

    public void render() {
        final RenderCarPartVisitor renderer = new RenderCarPartVisitor();
        for (final CarPart carPart : carParts) {
            carPart.acceptCarPartVisitor(renderer);
        }
    }

    public void print() {
        final PrintCarPartVisitor visitor = new PrintCarPartVisitor();
        for (final CarPart carPart : carParts) {
            carPart.acceptCarPartVisitor(visitor);
        }
    }

    public void upgrade() {
        final UpgradeCarPartVisitor visitor = new UpgradeCarPartVisitor();
        for (final CarPart carPart : carParts) {
            carPart.acceptCarPartVisitor(visitor);
        }
    }

}

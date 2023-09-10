package com.bastex.codelearninghub.designpatterns.behavioral.visitor;

public abstract class CarPart {
    void acceptCarPartVisitor(final CarPartVisitor visitor) {
        visitor.visit(this);
    }
}

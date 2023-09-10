package com.bastex.codelearninghub.designpatterns.behavioral.visitor;


public class PrintCarPartVisitor implements CarPartVisitor {
    @Override
    public void visit(final CarPart carPart) {
        System.out.println("Print " + carPart);
    }

}

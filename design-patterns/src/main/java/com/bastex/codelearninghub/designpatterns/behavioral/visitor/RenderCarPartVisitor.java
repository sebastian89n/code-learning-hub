package com.bastex.codelearninghub.designpatterns.behavioral.visitor;


public class RenderCarPartVisitor implements CarPartVisitor {
    @Override
    public void visit(final CarPart carPart) {
        System.out.println("Render " + carPart);
    }

}

package com.bastex.codelearninghub.designpatterns.behavioral.visitor;


public class UpgradeCarPartVisitor implements CarPartVisitor {
    @Override
    public void visit(final CarPart carPart) {
        System.out.println("Upgrade: " + carPart);
    }


}

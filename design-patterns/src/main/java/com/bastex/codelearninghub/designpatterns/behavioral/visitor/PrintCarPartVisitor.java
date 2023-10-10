package com.bastex.codelearninghub.designpatterns.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintCarPartVisitor implements CarPartVisitor {
    @Override
    public void visit(final CarPart carPart) {
        log.info("Print {}", carPart);
    }
}

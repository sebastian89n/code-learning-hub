package com.bastex.codelearninghub.designpatterns.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RenderCarPartVisitor implements CarPartVisitor {
    @Override
    public void visit(final CarPart carPart) {
        log.info("Render {}", carPart);
    }
}

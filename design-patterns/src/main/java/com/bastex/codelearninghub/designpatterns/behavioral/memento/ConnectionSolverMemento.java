package com.bastex.codelearninghub.designpatterns.behavioral.memento;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.geom.Point2D;

@RequiredArgsConstructor
@Getter
public class ConnectionSolverMemento {
    private final Point2D firstPoint;

    private final Point2D secondPoint;
}

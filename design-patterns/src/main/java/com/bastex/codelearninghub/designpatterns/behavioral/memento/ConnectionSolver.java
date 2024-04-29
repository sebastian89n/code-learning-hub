package com.bastex.codelearninghub.designpatterns.behavioral.memento;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.awt.geom.Point2D;

@Slf4j
public class ConnectionSolver {

    @Setter
    private Point2D firstPoint;

    @Setter
    private Point2D secondPoint;

    public void calculateLine() {
        log.info("Calculate line between: {} and {}", firstPoint, secondPoint);
    }

    public ConnectionSolverMemento createMemento() {
        return new ConnectionSolverMemento(firstPoint, secondPoint);
    }


    public void setMemento(final ConnectionSolverMemento memento) {
        firstPoint = memento.firstPoint();
        secondPoint = memento.secondPoint();
    }
}

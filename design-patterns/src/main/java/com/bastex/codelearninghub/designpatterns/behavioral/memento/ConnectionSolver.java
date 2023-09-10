package com.bastex.codelearninghub.designpatterns.behavioral.memento;


import lombok.Setter;

import java.awt.geom.Point2D;

public class ConnectionSolver {

    @Setter
    private Point2D firstPoint;

    @Setter
    private Point2D secondPoint;

    public void calculateLine() {
        System.out.println("Calculate line between: " + firstPoint + " and " + secondPoint);
    }

    public ConnectionSolverMemento createMemento() {
        return new ConnectionSolverMemento(firstPoint, secondPoint);
    }


    public void setMemento(final ConnectionSolverMemento memento) {
        firstPoint = memento.getFirstPoint();
        secondPoint = memento.getSecondPoint();
    }
}

package com.bastex.codelearninghub.designpatterns.behavioral.memento;


import java.awt.geom.Point2D;

public class MementoApp {
    public static void main(final String[] args) {
        final ConnectionSolver connectionSolver = new ConnectionSolver();
        final ConnectionSolverCaretaker caretaker = new ConnectionSolverCaretaker();

        connectionSolver.setFirstPoint(new Point2D.Double(1.0, 1.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0, 1.0));

        caretaker.saveState(connectionSolver);
        connectionSolver.calculateLine();

        connectionSolver.setFirstPoint(new Point2D.Double(2.0, 2.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0, 1.0));

        connectionSolver.calculateLine();

        final ConnectionSolver newConnectionSolver = new ConnectionSolver();
        caretaker.restoreState(newConnectionSolver);

        newConnectionSolver.calculateLine();

        caretaker.restoreState(connectionSolver);
        connectionSolver.calculateLine();
    }
}

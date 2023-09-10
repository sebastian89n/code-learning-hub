package com.bastex.codelearninghub.designpatterns.behavioral.memento;


public class ConnectionSolverCaretaker {

    private ConnectionSolverMemento connectionSolverMemento;

    public void saveState(final ConnectionSolver connectionSolver) {
        connectionSolverMemento = connectionSolver.createMemento();
    }

    public void restoreState(final ConnectionSolver connectionSolver) {
        connectionSolver.setMemento(connectionSolverMemento);
    }


}

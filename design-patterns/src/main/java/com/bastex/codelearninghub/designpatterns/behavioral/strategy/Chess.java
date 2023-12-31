package com.bastex.codelearninghub.designpatterns.behavioral.strategy;

public class Chess {
    private ChessAlgorithm algorithm = new EasyChessAlgorithm();

    public int calculateNextStep() {
        return algorithm.calculateNextStep();
    }

    public void setAlgorithm(final ChessAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}

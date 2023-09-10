package com.bastex.codelearninghub.designpatterns.behavioral.strategy;


public class HardChessAlgorithm implements ChessAlgorithm {
    @Override
    public int calculateNextStep() {
        return 3;
    }
}

package com.bastex.codelearninghub.designpatterns.behavioral.strategy;


public class EasyChessAlgorithm implements ChessAlgorithm {
    @Override
    public int calculateNextStep() {
        return 1;
    }
}

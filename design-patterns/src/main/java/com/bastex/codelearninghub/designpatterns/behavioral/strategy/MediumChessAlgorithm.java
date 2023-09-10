package com.bastex.codelearninghub.designpatterns.behavioral.strategy;


public class MediumChessAlgorithm implements ChessAlgorithm {
    @Override
    public int calculateNextStep() {
        return 2;
    }
}

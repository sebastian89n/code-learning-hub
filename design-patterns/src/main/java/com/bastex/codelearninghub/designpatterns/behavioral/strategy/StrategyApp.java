package com.bastex.codelearninghub.designpatterns.behavioral.strategy;


public class StrategyApp {

    public static void main(final String[] args) {
        final Chess chess = new Chess();

        System.out.println("Calculate next step: " + chess.calculateNextStep());
        chess.setAlgorithm(new HardChessAlgorithm());
        System.out.println("Calculate next step: " + chess.calculateNextStep());
    }

}

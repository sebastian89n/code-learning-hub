package com.bastex.codelearninghub.designpatterns.behavioral.strategy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyApp {
    public static void main(final String[] args) {
        final Chess chess = new Chess();

        log.info("Calculate next step: {}", chess.calculateNextStep());
        chess.setAlgorithm(new HardChessAlgorithm());
        log.info("Calculate next step: {}", chess.calculateNextStep());
    }

}

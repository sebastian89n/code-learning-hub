package com.bastex.codelearninghub.designpatterns.behavioral.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodApp {
    public static void main(final String[] args) {
        LoanCalculationAlgorithm loanCalculationAlgorithm = new ExpensiveLoanCalculation();
        log.info("Loan: {}", loanCalculationAlgorithm.calculateLoan());

        loanCalculationAlgorithm = new CheapLoanCalculation();
        log.info("Loan: {}", loanCalculationAlgorithm.calculateLoan());
    }
}

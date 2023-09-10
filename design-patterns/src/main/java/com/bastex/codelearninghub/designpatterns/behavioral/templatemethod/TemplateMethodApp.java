package com.bastex.codelearninghub.designpatterns.behavioral.templatemethod;


public class TemplateMethodApp {
    public static void main(final String[] args) {
        LoanCalculationAlgorithm loanCalculationAlgorithm = new ExpensiveLoanCalculation();
        System.out.println(loanCalculationAlgorithm.calculateLoan());

        loanCalculationAlgorithm = new CheapLoanCalculation();
        System.out.println(loanCalculationAlgorithm.calculateLoan());
    }
}

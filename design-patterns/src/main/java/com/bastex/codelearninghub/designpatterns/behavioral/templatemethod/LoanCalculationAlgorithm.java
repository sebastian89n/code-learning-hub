package com.bastex.codelearninghub.designpatterns.behavioral.templatemethod;


public abstract class LoanCalculationAlgorithm {
    public int calculateLoan() {
        return (int) (getBaseAmount() * getInterest() - caclulateDiscount());
    }

    abstract int getBaseAmount();

    abstract double getInterest();

    abstract int caclulateDiscount();
}

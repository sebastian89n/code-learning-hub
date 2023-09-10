package com.bastex.codelearninghub.designpatterns.structural.facade;

public class BillingSystem {
    public Bill createBill(final Integer amount) {
        // Let's assume some advanced logic happens here;
        return new Bill(amount);
    }
}

package com.bastex.codelearninghub.designpatterns.structural.facade;

public class InvoiceCustomerSystem {
    public void createInvoiceForBill(final Bill bill) {
        System.out.println("Creating invoice for bill with amount: " + bill.getAmount());
    }
}

package com.bastex.codelearninghub.designpatterns.structural.facade;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FinancialSystemFacade {
    private final BillingSystem billingSystem;

    private final InvoiceCustomerSystem invoiceCustomerSystem;

    public void createInvoice(final Integer amount) {
        final Bill bill = billingSystem.createBill(amount);
        invoiceCustomerSystem.createInvoiceForBill(bill);
    }
}

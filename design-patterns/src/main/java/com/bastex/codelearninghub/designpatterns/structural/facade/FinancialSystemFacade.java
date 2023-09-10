package com.bastex.codelearninghub.designpatterns.structural.facade;


import lombok.Setter;

@Setter
public class FinancialSystemFacade {

    private BillingSystem billingSystem;

    private InvoiceCustomerSystem invoiceCustomerSystem;

    public void createInvoice(final Integer amount) {
        final Bill bill = billingSystem.createBill(amount);
        invoiceCustomerSystem.createInvoiceForBill(bill);
    }
}

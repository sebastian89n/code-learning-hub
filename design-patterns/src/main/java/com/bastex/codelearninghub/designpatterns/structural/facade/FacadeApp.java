package com.bastex.codelearninghub.designpatterns.structural.facade;

public class FacadeApp {

    public static void main(final String[] args) {
        // initial setup
        final BillingSystem billingSystem = new BillingSystem();
        final InvoiceCustomerSystem invoiceCustomerSystem = new InvoiceCustomerSystem();

        final FinancialSystemFacade financialSystemFacade = new FinancialSystemFacade();
        financialSystemFacade.setBillingSystem(billingSystem);
        financialSystemFacade.setInvoiceCustomerSystem(invoiceCustomerSystem);

        financialSystemFacade.createInvoice(1000);
    }
}

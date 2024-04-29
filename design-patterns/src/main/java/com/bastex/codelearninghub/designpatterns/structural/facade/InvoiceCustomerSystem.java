package com.bastex.codelearninghub.designpatterns.structural.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoiceCustomerSystem {
    public void createInvoiceForBill(final Bill bill) {
        log.info("Creating invoice for bill with amount: {}", bill.getAmount());
    }
}

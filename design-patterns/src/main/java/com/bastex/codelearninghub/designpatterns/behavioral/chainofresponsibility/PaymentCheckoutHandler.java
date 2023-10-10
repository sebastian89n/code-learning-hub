package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentCheckoutHandler extends CheckoutHandler {
    @Override
    public void handleCheckout() {
        log.info("Handling payment of the customer");
    }
}

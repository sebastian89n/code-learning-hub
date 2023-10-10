package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerInfoCheckoutHandler extends CheckoutHandler {
    @Override
    void handleCheckout() {
        log.info("Adding extra info to checkout of the customer");
    }
}

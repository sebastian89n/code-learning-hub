package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;


public class CustomerInfoCheckoutHandler extends CheckoutHandler {
    @Override
    void handleCheckout() {
        System.out.println("Adding extra info to checkout of the customer");
    }
}

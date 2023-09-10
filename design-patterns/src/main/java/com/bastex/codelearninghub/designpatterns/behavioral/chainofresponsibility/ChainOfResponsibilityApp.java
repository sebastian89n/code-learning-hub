package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;


public class ChainOfResponsibilityApp {

    public static void main(final String[] args) {
        final PaymentCheckoutHandler handler = new PaymentCheckoutHandler();
        final CustomerInfoCheckoutHandler customerInfoCheckoutHandler = new CustomerInfoCheckoutHandler();

        handler.setNextHandler(customerInfoCheckoutHandler);
        handler.executeHandleCheckout();
    }
}

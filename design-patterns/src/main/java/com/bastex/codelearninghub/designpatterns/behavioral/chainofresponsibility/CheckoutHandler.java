package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;

public abstract class CheckoutHandler {
    protected CheckoutHandler nextHandler;

    public void executeHandleCheckout() {
        handleCheckout();

        if (nextHandler != null) {
            nextHandler.executeHandleCheckout();
        }
    }

    abstract void handleCheckout();

    public void setNextHandler(final CheckoutHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

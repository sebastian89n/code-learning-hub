package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;

import com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.requests.CheckoutRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class CheckoutHandler {
    private static final int MAX_SINGLE_ORDER_ITEMS_COUNT = 5;

    protected CheckoutHandler nextHandler;

    public void executeCheckout(@NonNull final CheckoutRequest checkoutRequest) {
        handleCheckout(checkoutRequest);

        if (nextHandler != null) {
            nextHandler.executeCheckout(checkoutRequest);
        }
    }

    protected abstract void handleCheckout(@NonNull CheckoutRequest checkoutRequest);

    private void addNextHandler(final CheckoutHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public static CheckoutHandler buildCheckoutProcedure(@NonNull final List<CheckoutHandler> checkoutHandlers) {
        if (checkoutHandlers.isEmpty()) {
            throw new IllegalArgumentException("Cannot build checkout procedure. No checkout handlers were provided");
        } else if (checkoutHandlers.size() == 1) {
            return checkoutHandlers.getFirst();
        } else {
            CheckoutHandler previousCheckoutHandler = null;
            for (final CheckoutHandler currentCheckoutHandler : checkoutHandlers) {
                if (previousCheckoutHandler != null) {
                    previousCheckoutHandler.addNextHandler(currentCheckoutHandler);
                }
                previousCheckoutHandler = currentCheckoutHandler;
            }

            return checkoutHandlers.getFirst();
        }
    }
}

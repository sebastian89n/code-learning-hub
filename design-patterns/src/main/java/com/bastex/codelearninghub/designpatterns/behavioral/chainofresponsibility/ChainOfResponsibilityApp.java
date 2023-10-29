package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility;


import com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.handlers.AddProductToShoppingCartCheckoutHandler;
import com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.handlers.PaymentCheckoutHandler;
import com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.requests.CheckoutRequest;

import java.util.List;

public class ChainOfResponsibilityApp {
    private static final long REQUEST_ID = 981234;

    public static void main(final String[] args) {
        final List<CheckoutHandler> checkoutHandlers = List.of(new AddProductToShoppingCartCheckoutHandler(),
                new PaymentCheckoutHandler());

        // TODO still improve this example
        final CheckoutHandler checkoutHandler = CheckoutHandler.buildCheckoutProcedure(checkoutHandlers);
        checkoutHandler.executeCheckout(new CheckoutRequest(REQUEST_ID));
    }
}

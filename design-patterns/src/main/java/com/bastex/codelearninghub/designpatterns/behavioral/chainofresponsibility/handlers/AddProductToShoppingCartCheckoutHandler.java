package com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.handlers;

import com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.CheckoutHandler;
import com.bastex.codelearninghub.designpatterns.behavioral.chainofresponsibility.requests.CheckoutRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddProductToShoppingCartCheckoutHandler extends CheckoutHandler {
    @Override
    protected void handleCheckout(@NonNull final CheckoutRequest checkoutRequest) {
        log.info("Adding product to shopping cart");
    }
}

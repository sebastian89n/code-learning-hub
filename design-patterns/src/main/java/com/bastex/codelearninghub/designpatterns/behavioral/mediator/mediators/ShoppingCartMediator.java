package com.bastex.codelearninghub.designpatterns.behavioral.mediator.mediators;


import com.bastex.codelearninghub.designpatterns.behavioral.mediator.domain.Product;

import java.util.List;

public interface ShoppingCartMediator {
    static ShoppingCartMediator newInstance() {
        return new ShoppingCartMediatorImpl();
    }

    void addProductForUser(final String username, Product product);

    List<Product> getUserProducts(final String username);
}

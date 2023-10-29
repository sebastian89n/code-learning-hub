package com.bastex.codelearninghub.designpatterns.behavioral.mediator.domain;


import com.bastex.codelearninghub.designpatterns.behavioral.mediator.mediators.ShoppingCartMediator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ProductShoppingModule {
    private final ShoppingCartMediator shoppingCartMediator;

    private final Map<Long, Product> productsById;

    public ProductShoppingModule(@NonNull final ShoppingCartMediator shoppingCartMediator, @NonNull final List<Product> products) {
        this.shoppingCartMediator = shoppingCartMediator;
        this.productsById = products.stream()
                .collect(Collectors.toMap(Product::id, Function.identity()));
    }

    public void addProductToCart(@NonNull final String username, final long productId) {
        final Product product = productsById.get(productId);
        if (product != null) {
            shoppingCartMediator.addProductForUser(username, product);
        } else {
            log.warn("Product with id {} not found", productId);
        }
    }
}

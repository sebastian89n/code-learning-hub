package com.bastex.codelearninghub.designpatterns.behavioral.mediator.mediators;

import com.bastex.codelearninghub.designpatterns.behavioral.mediator.domain.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
class ShoppingCartMediatorImpl implements ShoppingCartMediator {
    private final Map<String, List<Product>> productsPerUsername = new LinkedHashMap<>();

    @Override
    public void addProductForUser(@NonNull final String username, @NonNull final Product product) {
        validateUsername(username);

        productsPerUsername.computeIfAbsent(username, k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public List<Product> getUserProducts(@NonNull final String username) {
        validateUsername(username);
        return productsPerUsername.getOrDefault(username, Collections.emptyList());
    }

    private static void validateUsername(final String username) {
        if (username.isBlank()) {
            throw new IllegalArgumentException("User cannot be empty");
        }
    }
}

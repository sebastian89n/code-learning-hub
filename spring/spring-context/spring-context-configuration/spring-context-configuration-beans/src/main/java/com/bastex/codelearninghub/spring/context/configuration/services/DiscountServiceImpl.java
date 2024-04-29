package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final double baseDiscount;

    @Override
    public Product applyDiscount(@NonNull final Product product) {
        return new Product(product.id(), product.name(), product.price() * baseDiscount);
    }
}

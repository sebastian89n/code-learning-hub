package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.Product;

import java.util.Set;

public class ProductServiceImpl implements ProductService {
    @Override
    public Set<Product> findAllProducts() {
        return Set.of(new Product(1L, "Samsung Odyssey Neo G8", 4999),
                new Product(2L, "One Plus 11", 3200),
                new Product(3L, "Playstation 5", 2199));
    }
}

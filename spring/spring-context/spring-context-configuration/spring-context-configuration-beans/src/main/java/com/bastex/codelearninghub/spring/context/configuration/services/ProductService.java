package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.Product;

import java.util.Set;

public interface ProductService {
    Set<Product> findAllProducts();
}

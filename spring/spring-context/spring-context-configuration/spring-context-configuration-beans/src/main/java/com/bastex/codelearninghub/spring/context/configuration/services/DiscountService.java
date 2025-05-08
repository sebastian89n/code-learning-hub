package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.Product;

public interface DiscountService {
    Product applyDiscount(Product product);
}

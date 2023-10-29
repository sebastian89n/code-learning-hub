package com.bastex.codelearninghub.designpatterns.behavioral.mediator;


import com.bastex.codelearninghub.designpatterns.behavioral.mediator.domain.Product;
import com.bastex.codelearninghub.designpatterns.behavioral.mediator.domain.ProductShoppingModule;
import com.bastex.codelearninghub.designpatterns.behavioral.mediator.mediators.ShoppingCartMediator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MediatorApp {
    private static final String USER = "john.smith@gmail.com";

    public static void main(final String[] args) {
        final ShoppingCartMediator shoppingCartMediator = ShoppingCartMediator.newInstance();

        final ProductShoppingModule smartphonesShoppingModule = prepareSmartphonesShoppingModule(shoppingCartMediator);
        final ProductShoppingModule consolesShoppingModule = prepareConsolesShoppingModule(shoppingCartMediator);

        smartphonesShoppingModule.addProductToCart(USER, 2);
        consolesShoppingModule.addProductToCart(USER, 1);

        final List<Product> userProducts = shoppingCartMediator.getUserProducts(USER);
        log.info("Selected value is: {}", userProducts);
    }

    private static ProductShoppingModule prepareSmartphonesShoppingModule(final ShoppingCartMediator shoppingCartMediator) {
        final List<Product> smartphones = List.of(
                new Product(1, "Samsung Galaxy S23"),
                new Product(2, "One Plus 13"),
                new Product(3, "Iphone 14")
        );

        return new ProductShoppingModule(shoppingCartMediator, smartphones);
    }

    private static ProductShoppingModule prepareConsolesShoppingModule(final ShoppingCartMediator shoppingCartMediator) {
        final List<Product> consoles = List.of(
                new Product(1, "Playstation 5"),
                new Product(2, "Xbox Series X"),
                new Product(3, "Nintendo Switch")
        );

        return new ProductShoppingModule(shoppingCartMediator, consoles);
    }
}

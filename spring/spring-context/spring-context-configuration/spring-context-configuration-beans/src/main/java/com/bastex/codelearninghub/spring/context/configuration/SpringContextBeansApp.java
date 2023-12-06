package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.beans.Product;
import com.bastex.codelearninghub.spring.context.configuration.services.DiscountService;
import com.bastex.codelearninghub.spring.context.configuration.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Set;

@Slf4j
public class SpringContextBeansApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            applicationContext.register(SpringContextBeansConfiguration.class);

            // or pass via VM params -Dspring.profiles.active=discount
            applicationContext.getEnvironment().setActiveProfiles("discount");
            applicationContext.refresh();

            final ProductService productService = applicationContext.getBean(ProductService.class);
            final Set<Product> allProducts = productService.findAllProducts();
            log.info("Products: {}", allProducts);

            final DiscountService discountService = applicationContext.getBean(DiscountService.class);
            final List<Product> discountedProducts = allProducts.stream().map(discountService::applyDiscount).toList();
            log.info("Discounted products: {}", discountedProducts);
        }
    }
}

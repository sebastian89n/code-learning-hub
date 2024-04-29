package com.bastex.codelearninghub.java.libs.mapstruct.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Ingredient {
    private String description;

    private BigDecimal amount;
}

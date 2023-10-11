package com.bastex.codelearninghub.java.libs.mapstruct.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientDTO {
    private String name;

    private BigDecimal amount;
}

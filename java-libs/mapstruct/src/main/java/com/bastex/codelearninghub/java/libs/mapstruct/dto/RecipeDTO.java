package com.bastex.codelearninghub.java.libs.mapstruct.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RecipeDTO {
    private String name;

    private Integer preparationTimeInMinutes;

    private Integer cookingTimeInMinutes;

    private Integer servings;

    private String direction;

    private DifficultyDTO difficulty;

    private Set<IngredientDTO> ingredients;

    private Set<String> alternativeNames;
}

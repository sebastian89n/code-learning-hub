package com.bastex.codelearninghub.java.libs.mapstruct.domain;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    private Long id;

    private Description description;

    private Integer prepTime;

    private Integer cookTime;

    private Integer servings;

    private String url;

    private String direction;

    private Difficulty difficulty;

    private List<Ingredient> ingredients;

    private List<String> alternativeNames;
}

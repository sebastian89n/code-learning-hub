package com.bastex.codelearninghub.java.libs.mapstruct;

import com.bastex.codelearninghub.java.libs.mapstruct.domain.Description;
import com.bastex.codelearninghub.java.libs.mapstruct.domain.Difficulty;
import com.bastex.codelearninghub.java.libs.mapstruct.domain.Ingredient;
import com.bastex.codelearninghub.java.libs.mapstruct.domain.Recipe;
import com.bastex.codelearninghub.java.libs.mapstruct.dto.RecipeDTO;
import com.bastex.codelearninghub.java.libs.mapstruct.transformers.RecipeTransformer;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class MapstructApp {
    public static void main(final String[] args) {
        final Recipe originalRecipe = new Recipe();
        originalRecipe.setId(5L);
        originalRecipe.setDescription(new Description("Lasagna"));
        originalRecipe.setDifficulty(Difficulty.MODERATE);
        originalRecipe.setUrl("https://www.allrecipes.com/recipe/23600/worlds-best-lasagna/");
        originalRecipe.setCookTime(160);
        originalRecipe.setPrepTime(30);
        originalRecipe.setAlternativeNames(List.of("gnocchi", "tortellini"));
        originalRecipe.setServings(12);
        originalRecipe.setDirection("<INSTRUCTIONS>");

        final Ingredient ingredient1 = new Ingredient();
        ingredient1.setDescription("lasagna noodles");
        ingredient1.setAmount(new BigDecimal(1));

        originalRecipe.setIngredients(List.of(ingredient1));

        final RecipeDTO recipeDTO = RecipeTransformer.INSTANCE.toRecipeDTO(originalRecipe);
        log.info("RecipeDTO: {}", recipeDTO);

        final Recipe transformedRecipe = RecipeTransformer.INSTANCE.toRecipe(recipeDTO);
        log.info("Recipe: {}", transformedRecipe);
    }
}

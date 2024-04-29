package com.bastex.codelearninghub.java.libs.mapstruct.transformers;

import com.bastex.codelearninghub.java.libs.mapstruct.domain.Ingredient;
import com.bastex.codelearninghub.java.libs.mapstruct.domain.Recipe;
import com.bastex.codelearninghub.java.libs.mapstruct.dto.IngredientDTO;
import com.bastex.codelearninghub.java.libs.mapstruct.dto.RecipeDTO;
import com.bastex.codelearninghub.java.libs.mapstruct.transformers.common.MapperBaseConfig;
import com.bastex.codelearninghub.java.libs.mapstruct.transformers.common.MapperUtilities;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(config = MapperBaseConfig.class, uses = MapperUtilities.class)
public interface RecipeTransformer {
    @Mapping(target = "name", source = "description.name")
    @Mapping(target = "preparationTimeInMinutes", source = "prepTime")
    @Mapping(target = "cookingTimeInMinutes", source = "cookTime")
    @Mapping(target = "ingredientsSummaryAsText", ignore = true)
        // ingredientsSummaryAsText is filled up in afterMapping method
    RecipeDTO toRecipeDTO(Recipe recipe);

    @NameToDescription
        // maps value from inner object + uses custom interface
    IngredientDTO toIngredientDTO(Ingredient ingredient);

    @Mapping(target = "description.name", source = "name")
    @Mapping(target = "prepTime", source = "preparationTimeInMinutes")
    @Mapping(target = "cookTime", source = "cookingTimeInMinutes")
    @Mapping(target = "id", ignore = true)
    Recipe toRecipe(RecipeDTO recipeDTO);

    @Mapping(target = "description", source = "name")
    Ingredient toIngredient(IngredientDTO ingredientDTO);

    @AfterMapping
    default void afterMapping(final Recipe recipe, @MappingTarget final RecipeDTO recipeDTO) {
        final List<Ingredient> ingredients = recipe.getIngredients();
        if (ingredients != null && !ingredients.isEmpty()) {
            final String ingredientsSummary = ingredients.stream()
                    .map(ingredient -> ingredient.getDescription() + "[" + ingredient.getAmount() + "]")
                    .collect(Collectors.joining("\n"));

            recipeDTO.setIngredientsSummaryAsText("Summary of ingredients: \n" + ingredientsSummary);
        }
    }
}

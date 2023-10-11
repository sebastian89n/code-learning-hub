package com.bastex.codelearninghub.java.libs.mapstruct.transformers;

import com.bastex.codelearninghub.java.libs.mapstruct.domain.Ingredient;
import com.bastex.codelearninghub.java.libs.mapstruct.domain.Recipe;
import com.bastex.codelearninghub.java.libs.mapstruct.dto.IngredientDTO;
import com.bastex.codelearninghub.java.libs.mapstruct.dto.RecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Mapper
public interface RecipeTransformer {
    /**
     * In real application best to be mapped as Bean in CDI/Spring Context
     */
    RecipeTransformer INSTANCE = Mappers.getMapper(RecipeTransformer.class);

    @Mapping(target = "name", source = "description.name") // maps value from inner object
    @Mapping(target = "preparationTimeInMinutes", source = "prepTime")
    @Mapping(target = "cookingTimeInMinutes", source = "cookTime")
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

    /**
     * Forcing Mapstruct to transform List to unmodifiable Set.
     */
    default <T> Set<T> toSet(final List<T> list) {
        if (list == null) {
            return Collections.emptySet();
        } else {
            return Collections.unmodifiableSet(new LinkedHashSet<>(list));
        }
    }
}

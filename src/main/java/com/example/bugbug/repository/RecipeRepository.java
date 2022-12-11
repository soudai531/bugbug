package com.example.bugbug.repository;

import com.example.bugbug.entity.Recipe;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAll();

    /**
     * レシピ検索
     */
    @Query("SELECT * FROM `recipes` WHERE name LIKE :keyword")
    List<Recipe> searchRecipe(@Param("keyword") String keyword);

    /**
     * レシピ名とタグ名からレシピを検索する
     */
    @Query("SELECT DISTINCT recipes.recipe_id, recipes.user_id, recipes.name, recipes.image, recipes.image_blurred, recipes.browes " +
            "FROM recipes INNER JOIN tags INNER JOIN recipe_tags " +
            "ON recipes.recipe_id = recipe_tags.recipe_id " +
            "AND tags.tag_id = recipe_tags.tag_id " +
            "AND tags.name LIKE :keyword OR recipes.name LIKE :keyword;")
    List<Recipe> searchRecipeNameTag(@Param("keyword") String keyword);
}

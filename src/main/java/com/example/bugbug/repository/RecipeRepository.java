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
    @Query("SELECT * FROM recipes WHERE name LIKE '%:keyword%' ")
    Optional<Recipe> serchRecipe(@Param("keyword") String keyword);
}

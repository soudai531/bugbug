package com.example.bugbug.repository;

import com.example.bugbug.entity.RecipeTag;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeTagsRepository extends CrudRepository<RecipeTag, Integer> {
    // レシピ
    @Query("SELECT * FROM recipe_tags WHERE recipe_id = :recipe_id")
    List<RecipeTag> getRecipeTagsId(int recipe_id);
}

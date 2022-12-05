
package com.example.bugbug.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.bugbug.entity.RecipeTag;

public interface RecipeTagRepository extends CrudRepository<RecipeTag, Integer> {

    /**
     * レシピに紐づいているタグidをリストで返す
     * @param recipeId レシピid
     * @return レシピに紐づいているレシピタグ
     */
    @Query("SELECT * FROM recipe_tags WHERE recipe_id = :recipeId")
    List<RecipeTag> getRecipeTagsId(@Param("recipeId")int recipeId);
    
    
}
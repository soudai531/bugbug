package com.example.bugbug.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.bugbug.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAll();
    
    //ユーザーIDの取得
    @Query("select max(recipe_id) from recipes ")
    int getId();
    
    // ユーザーアイコンの更新
 	@Modifying
 	@Query("UPDATE recipes SET image = :fileName WHERE recipe_id = :recipeId")
 	void updateRecipeImage(@Param("fileName") String fileName, @Param("recipeId") int recipeId);
}

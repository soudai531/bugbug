package com.example.bugbug.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.bugbug.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

	//レシピの取得
    List<Recipe> findAll();
    
    // レシピ画像の更新
 	@Modifying
 	@Query("UPDATE recipes SET image = :fileName WHERE recipe_id = :recipeId")
 	void updateRecipeImage(@Param("fileName") String fileName, @Param("recipeId") int recipeId);
 	
 	//ビュー数の増加
 	@Modifying
 	@Query("UPDATE recipes SET views = views+1 WHERE recipe_id = :recipeId")
 	void BroweCounta(@Param("recipeId") int recipeId);
}

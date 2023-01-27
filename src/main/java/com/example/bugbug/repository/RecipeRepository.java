package com.example.bugbug.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jdbc.repository.query.Modifying;
import com.example.bugbug.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

	//レシピの取得
    List<Recipe> findAll();

    /**
     * レシピ名と説明とタグ名からキーワードによるレシピ検索（閲覧数による降順）
     */
    @Query("SELECT DISTINCT recipes.recipe_id, recipes.user_id, recipes.name, recipes.image, recipes.image_blurred, recipes.views " +
            "FROM recipes INNER JOIN tags INNER JOIN recipe_tags " +
            "ON recipes.recipe_id = recipe_tags.recipe_id " +
            "AND tags.tag_id = recipe_tags.tag_id " +
            "AND tags.name LIKE :keyword " +
            "AND recipes.deleted = 0 "+
            "OR recipes.name LIKE :keyword " +
            "OR recipes.explanation LIKE :keyword " +
            "ORDER BY recipes.views DESC;")
    List<Recipe> searchRecipeNameTag(@Param("keyword") String keyword);

	/**
	 * タグIDからレシピを検索（閲覧数による降順）
	 * @param tagId 検索するタグのID
	 * @return タグIDによる検索結果
	 */
	@Query("SELECT DISTINCT recipes.recipe_id, recipes.user_id, recipes.name, recipes.image, recipes.image_blurred, recipes.views " +
			"FROM recipes INNER JOIN recipe_tags " +
			"ON recipes.recipe_id = recipe_tags.recipe_id " +
			"AND recipes.deleted = 0 " +
			"AND recipe_tags.tag_id = :tagId " +
			"ORDER BY recipes.views DESC;")
	List<Recipe> searchRecipeTagId(@Param("tagId") String tagId);



    // レシピ画像の更新
 	@Modifying
 	@Query("UPDATE recipes SET image = :fileName WHERE recipe_id = :recipeId")
 	void updateRecipeImage(@Param("fileName") String fileName, @Param("recipeId") int recipeId);
 	
 	//ビュー数の増加
 	@Modifying
 	@Query("UPDATE recipes SET views = views+1 WHERE recipe_id = :recipeId")
 	void ViewCount(@Param("recipeId") int recipeId);


}

package com.example.bugbug.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.bugbug.entity.RecipeMaterial;

public interface MaterialRepository extends CrudRepository<RecipeMaterial, Integer> {

	/**
     * レシピに紐づいている材料をリストで返す
     * @param recipeId レシピid
     * @return レシピに紐づいている材料
     */
    @Query("SELECT * FROM recipe_materials WHERE recipe_id = :recipeId")
    List<RecipeMaterial> getMaterialsByID(@Param("recipeId")int recipeId);
}

package com.example.bugbug.service;

import java.util.List;
import java.util.Optional;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.service.dto.RecipeDto;

public interface RecipeService {

    // レシピをすべて取得
    List<RecipeDto> getAllRecipe();

    // おすすめレシピを20件ずつ取得
    List<RecipeDto> getRecommendRecipe(int page);
    
    //特定のレシピの取得
    Optional<Recipe> getRecipe(int recipeId);
    
    //レシピタグの取得
    List<RecipeTag> getRecipeTag(int recipeId);
    
    //レシピ手順の取得
    List<RecipeProcedure> getProcedure(int recipeId);
    
    //レシピ材料の取得
    List<RecipeMaterial> getMaterial(int recipeId);
    
    //ビュー数の増加
    void addBrow(int recipeId);
}

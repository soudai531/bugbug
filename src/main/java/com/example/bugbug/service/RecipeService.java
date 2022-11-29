package com.example.bugbug.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.service.dto.RecipeDto;

public interface RecipeService {

    // レシピをすべて取得
    List<RecipeDto> getAllRecipe();

    // おすすめレシピを20件ずつ取得
    List<RecipeDto> getRecommendRecipe(int page);
    
    //レシピ登録
    Recipe saveRecipe(Recipe recipe);
    
    //画像の登録
    public String saveRecipeImage(MultipartFile file, int recipe_id);
    
    //タグの登録
    public void saveTag(int recipe_id,List<String> tags);
    
    //材料の登録
    public void saveMaterial(int recipe_id,List<String> materiaals,List<String> amounts);
}

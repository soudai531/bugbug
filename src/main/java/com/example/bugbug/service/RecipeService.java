package com.example.bugbug.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.form.RecipeRegisterForm;
import com.example.bugbug.service.dto.RecipeDto;

public interface RecipeService {

    // レシピをすべて取得
    List<RecipeDto> getAllRecipe();

    // おすすめレシピを20件ずつ取得
    List<RecipeDto> getRecommendRecipe(int page);
    
    //レシピ登録
    Recipe saveRecipe(Recipe recipe);
    
    //エンティティの作
    public Recipe createRecipe(RecipeRegisterForm form);
    
    //画像の登録
    public String saveRecipeImage(MultipartFile file, int recipe_id);
    
    //タグの登録
    public void saveRecipeTag(int recipe_id,List<String> tags);
    
    //材料の登録
    public void saveMaterial(int recipe_id,List<String> materiaals,List<String> amounts);
    
    //手順の登録
    public void saveProcedure(int recipe_id,List<MultipartFile> images,List<String> contexts);
}

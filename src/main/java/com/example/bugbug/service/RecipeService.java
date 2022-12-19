package com.example.bugbug.service;

import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.service.dto.RecipeDetailDTO;
import com.example.bugbug.service.dto.RecipeDto;
import com.example.bugbug.form.RecipeRegisterForm;

public interface RecipeService {

    // レシピをすべて取得
    List<RecipeDto> getAllRecipe();

    // おすすめレシピを20件ずつ取得
    List<RecipeDto> getRecommendRecipe(int page);

    RecipeDto repackRecipeDto(Recipe recipe);

    // レシピIdからレシピ詳細情報を取得する
    RecipeDetailDTO getRecipeDetail(int recipeId);

    // 特定のレシピの取得
    Optional<Recipe> getRecipe(int recipeId);
    
    // レシピタグの取得
    List<Tag> getRecipeTag(int recipeId);
    
    // レシピ手順の取得
    List<RecipeProcedure> getProcedure(int recipeId);
    
    // レシピ材料の取得
    List<RecipeMaterial> getMaterial(int recipeId);

    //ビュー数の増加
    void addView(int recipeId);

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

    String saveProcedureImage(MultipartFile file, int ProcedureId);
}

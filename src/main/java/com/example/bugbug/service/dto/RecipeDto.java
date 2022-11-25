package com.example.bugbug.service.dto;

import com.example.bugbug.entity.Recipes;
import lombok.Data;

@Data
public class RecipeDto {
    // レシピ情報
    private int recipeId;
    private String recipeUrl;
    private String recipeImageUrl;
    private String recipeName;

    // 投稿者情報
    private int postUserId;
    private int postUserUrl;
    private int postUserImageUrl;
    private String postUserName;

    // お気に入り数
    private int favoriteNumber;

    // タグ


    /**
     * コンストラクタ
     * @param recipe
     */
    public RecipeDto(Recipes recipe){
        this.recipeId = recipe.getRecipe_id();
        this.recipeUrl = "/recipe/" + recipe.getRecipe_id();
        this.recipeName = recipe.getName();
        this.postUserId = recipe.getUser_id();
    }
}

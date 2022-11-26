package com.example.bugbug.service.dto;

import com.example.bugbug.entity.Recipes;
import com.example.bugbug.entity.Tags;
import com.example.bugbug.entity.Users;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private List<Tags> tags = new ArrayList<>();;

    /**
     * コンストラクタ
     * @param recipe
     */
    public RecipeDto(Recipes recipe){
        this.recipeId = recipe.getRecipeId();
        this.recipeUrl = "/recipe/" + recipe.getRecipeId();
        // Todo 写真urlの作成
        
        this.recipeName = recipe.getName();
        this.postUserId = recipe.getUserId();
    }

    /**
     * タグ情報を格納する
     */
    public void ofTag(List<Tags> tags) {
        tags.forEach(tag -> this.tags.add(tag));
    }

    /**
     * 投稿ユーザー情報を格納
     */
    public void ofUser(List<Users> user){

    }

    /**
     * お気に入り数を格納
     */
    public void ofFavorite(int favoriteNum){

    }

}

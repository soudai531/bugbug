package com.example.bugbug.service.dto;

import lombok.Data;

@Data
public class RecipeDto {
    // レシピ情報
    private int recipeId;
    private int recipeUrl;
    private String recipeImageUrl;
    private String recipeName;

    // 投稿者情報
    private int postUserId;
    private int postUserUrl;
    private int postUserImageUrl;
    private String postUserName;

    // お気に入り数
    private int favoriteNumber;

    //タグ情報１
    private int tag1Id;
    private int tag1Url;
    private String tag1Name;

    // タグ情報２
    private int tag2Id;
    private int tag2Url;
    private String tag2Name;

    RecipeDto(){

    }
}

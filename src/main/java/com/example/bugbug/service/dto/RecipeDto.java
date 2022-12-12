package com.example.bugbug.service.dto;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDto {
    // レシピ情報
    private int recipeId;
    private String recipeImage;
    private String recipeName;

    // 投稿者情報
    private int postUserId;
    private String postUserImage;
    private String postUserName;

    // お気に入り数
    private int favoriteNumber;

    // タグ
    private List<Tag> tags = new ArrayList<>();;

    /**
     * コンストラクタ
     * @param recipe
     */
    public RecipeDto(Recipe recipe){
        this.recipeId = recipe.getRecipeId();
        this.recipeImage = recipe.getImage();
        this.recipeName = recipe.getName();
        this.postUserId = recipe.getUserId();
    }

    /**
     * タグ情報を格納する
     */
    public void ofTag(List<Tag> tags) {
        tags.forEach(tag -> this.tags.add(tag));
    }

    /**
     * 投稿ユーザー情報を格納
     */
    public void ofUser(User user){
        this.postUserId = user.getUserId();
        this.postUserName = user.getName();
        this.postUserImage = user.getIcon();
    }

    /**
     * お気に入り数を格納
     */
    public void ofFavorite(int favoriteNum){
        this.favoriteNumber = favoriteNum;
    }

}

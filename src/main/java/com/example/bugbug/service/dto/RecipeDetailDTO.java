package com.example.bugbug.service.dto;

import com.example.bugbug.entity.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RecipeDetailDTO {
    // レシピ情報
    private Integer recipeId;
    private String recipeName;
    private String recipeImage;
    private String explanation;
    private String point;
    private Integer imageBlurred;
    private Date regDateOn;

    // 投稿者情報
    private int postUserId;
    private String postUserImage;
    private String postUserName;

    // お気に入り数
    private int favoriteNumber;

    // タグ
    private List<Tag> tags = new ArrayList<>();
    // 材料
    private List<RecipeMaterial> materials = new ArrayList<>();
    // 手順
    private List<RecipeProcedure> procedures = new ArrayList<>();


    public RecipeDetailDTO(Recipe recipe, User user, int favorite, List<Tag> tags, List<RecipeProcedure> procedures, List<RecipeMaterial> materials){
        this.recipeId = recipe.getRecipeId();
        this.recipeImage = recipe.getImage();
        this.recipeName = recipe.getName();
        this.explanation = recipe.getExplanation();
        this.point = recipe.getPoint();
        this.imageBlurred = recipe.getImageBlurred();
        this.regDateOn = recipe.getRegDateOn();
        this.postUserId = user.getUserId();
        this.postUserName = user.getName();
        this.postUserImage = user.getIcon();
        this.favoriteNumber = favorite;
        this.tags = tags;
        this.procedures = procedures;
        this.materials = materials;
    }

}

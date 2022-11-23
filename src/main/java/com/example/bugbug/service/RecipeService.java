package com.example.bugbug.service;

import com.example.bugbug.service.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    // レシピをすべて取得
    List<RecipeDto> getRecipe();

    // おすすめレシピを20件取得
    List<RecipeDto> getRecommendRecipe();
}

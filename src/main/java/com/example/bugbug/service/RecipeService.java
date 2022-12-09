package com.example.bugbug.service;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.service.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    // レシピをすべて取得
    List<RecipeDto> getAllRecipe();

    // おすすめレシピを20件ずつ取得
    List<RecipeDto> getRecommendRecipe(int page);

    // レシピをDtoに詰めなおす
    RecipeDto repackDto(Recipe recipe);
}

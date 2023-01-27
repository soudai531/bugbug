package com.example.bugbug.service;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.repository.RecipeRepository;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

    private final RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    /**
     * キーワードからレシピを検索して、20件取得する
     *
     * @param keyword
     */
    @Override
    public List<RecipeDto> searchKeyword(final String keyword) {
        // Todo ページネーション
        String queryKeyword = "%" + keyword + "%";
        // keywordからレシピを検索して取得
        List<Recipe> recipeList = recipeRepository.searchRecipeNameTag(queryKeyword);
        // レシピDTOに詰めなおす
        List<RecipeDto> result = new ArrayList<>();
        for(Recipe recipe : recipeList) {
            result.add(recipeService.repackDto(recipe));
        }
        System.out.println(result);
        return result;
    }

    /**
     * キーワードからレシピを検索して、20件取得する
     *
     * @param tagId
     */
    @Override
    public List<RecipeDto> searchTagId(final String tagId) {
        // Todo ページネーション
        // keywordからレシピを検索して取得
        List<Recipe> recipeList = recipeRepository.searchRecipeTagId(tagId);
        System.out.println(recipeList);
        // レシピDTOに詰めなおす
        List<RecipeDto> result = new ArrayList<>();
        for(Recipe recipe : recipeList) {
            result.add(recipeService.repackDto(recipe));
        }
        System.out.println(result);
        return result;
    }
}

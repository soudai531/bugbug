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
     * @param keyword
     * @param page
     */
    @Override
    public List<RecipeDto> searchKeyword(final String keyword, final int page) {
        String queryKeyword = "%" + keyword + "%";
        System.out.println(keyword);
        // keywordからレシピを検索して取得
        List<Recipe> recipeList = recipeRepository.searchRecipe(queryKeyword);
        // レシピDTOに詰めなおす
        List<RecipeDto> result = new ArrayList<>();
        for(Recipe recipe : recipeList) {
            result.add(recipeService.repackDto(recipe));
        }
        System.out.println(result);
        return result;
    }
}

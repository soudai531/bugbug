package com.example.bugbug.service;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import com.example.bugbug.repository.RecipeTagRepository;
import com.example.bugbug.repository.RecipeRepository;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeTagRepository recipeTagRepository;

    private TagService tagService;
    private AccountService accountService;

    /**
     *レシピをすべて取得
     */
    @Override
    public List<RecipeDto> getAllRecipe(){
        //レシピの全件取得
        List<Recipe> recipes = recipeRepository.findAll();
        // レシピDTOのリストを作成
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        //　レシピをDTOに詰め替える
        for(Recipe recipe :recipes) {
            recipeDtoList.add(repackDto(recipe));
        }
        System.out.println(recipeDtoList);
        return recipeDtoList;
    }

    /**
     * おすすめのレシピを取得する
     */
    @Override
    public List<RecipeDto> getRecommendRecipe(int page){
        return new ArrayList<RecipeDto>();
    }


    /**
     * レシピ情報からレシピDTOを作成する
     */
    public RecipeDto repackDto(Recipe recipe){
            RecipeDto recipeDto = new RecipeDto(recipe);
            // Todo レシピ画像URLを格納する

            // レシピについているタグIDを取得
            List<RecipeTag> recipeTags = recipeTagRepository.getRecipeTagsId(recipe.getRecipeId());
            //　レシピについているタグのタグ情報をまとめて取得
            List<Tag> tags = tagService.getTags(recipeTags);
            // DTOにタグ情報を格納
            recipeDto.ofTag(tags);
            // Todo　ユーザー情報を格納する
            User user = accountService.findUserId(recipe.getUserId());
            recipeDto.ofUser(user);
            // Todo お気に入り数を格納する

            return recipeDto;
    }
}

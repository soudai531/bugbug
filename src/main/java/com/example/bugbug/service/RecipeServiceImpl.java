package com.example.bugbug.service;

import com.example.bugbug.entity.RecipeTags;
import com.example.bugbug.entity.Recipes;
import com.example.bugbug.entity.Tags;
import com.example.bugbug.repository.RecipeTagsRepository;
import com.example.bugbug.repository.RecipesRepository;
import com.example.bugbug.repository.TagsRepository;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipesRepository recipesRepository;
    private RecipeTagsRepository recipeTagsRepository;
    private TagsRepository tagsRepository;
    private TagsService tagService;

    /**
     *レシピをすべて取得
     */
    @Override
    public List<RecipeDto> getAllRecipe(){
        //レシピの全件取得
        List<Recipes> recipes = recipesRepository.findAll();
        // レシピDTOのリストを作成
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        //　レシピをDTOに詰め替える
        for(Recipes recipe :recipes) {
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
    public RecipeDto repackDto(Recipes recipe){
            RecipeDto recipeDto = new RecipeDto(recipe);
            // Todo レシピ画像URLを格納する

            // レシピについているタグIDを取得
            List<RecipeTags> recipeTags = recipeTagsRepository.getRecipeTagsId(recipe.getRecipe_id());
            //　レシピについているタグのタグ情報をまとめて取得
            List<Tags> tags = tagService.getTags(recipeTags);
            // DTOにタグ情報を格納
            recipeDto.ofTag(tags);
            // Todo　ユーザー情報を格納する

            // Todo お気に入り数を格納する

            return recipeDto;
    }
}

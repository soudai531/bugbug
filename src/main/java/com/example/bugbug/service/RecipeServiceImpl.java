package com.example.bugbug.service;

import com.example.bugbug.entity.RecipeTags;
import com.example.bugbug.entity.RecipeTagsKey;
import com.example.bugbug.entity.Recipes;
import com.example.bugbug.repository.RecipeTagsRepository;
import com.example.bugbug.repository.RecipesRepository;
import com.example.bugbug.repository.TagsRepository;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipesRepository recipesRepository;
    private TagsRepository tagsRepository;
    private RecipeTagsRepository recipeTagsRepository;

    /**
     *レシピをすべて取得
     */
    @Override
    public void getAllRecipe(){
        List<Recipes> recipes = recipesRepository.findAll();
        List<RecipeDto> recipeDtoList = new ArrayList<>();
//            Optional<RecipeTags> recipeTags = recipeTagsRepository.findById(recipe.getRecipe_id());
            System.out.println(tagsRepository.findById(1));
//            RecipeTagsKey recipeTagskey = new RecipeTagsKey(1,1);
//            System.out.println(recipeTagsRepository.findById(recipeTagskey));
//        recipes.forEach(recipe -> recipeDtoList.add(new RecipeDto(recipe)));
//        System.out.println(recipeDtoList);
    }
}

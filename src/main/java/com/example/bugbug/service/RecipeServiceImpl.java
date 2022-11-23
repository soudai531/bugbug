package com.example.bugbug.service;

import com.example.bugbug.entity.Recipes;
import com.example.bugbug.repository.RecipesRepository;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipesRepository repository;

    /**
     *レシピをすべて取得
     */
    @Override
    public void getAllRecipe(){
        Iterable<Recipes> recipes = repository.findAll();
        recipes.forEach(recipe -> System.out.println(recipe.getUser_id()));
    }
}

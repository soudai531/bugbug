package com.example.bugbug.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import com.example.bugbug.service.AccountService;
import com.example.bugbug.service.FavoriteService;
import com.example.bugbug.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RecipeController {
	
	@Autowired
    private HttpSession session;
    private final RecipeService recipeService;
    private final AccountService accountService;
    private final FavoriteService favoriteService;
	
	//レシピ詳細画面の表示
	@GetMapping("recipes/*")
	public String viewRecipeDetail(@RequestParam(value="recipeId")int recipe_id,Model model) {
		//レシピ詳細情報の取得
		Optional<Recipe> recipe = recipeService.getRecipe(recipe_id);
		List<Tag> recipeTags = recipeService.getRecipeTag(recipe_id);
		List<RecipeProcedure> procuderes = recipeService.getProcedure(recipe_id);
		List<RecipeMaterial> materials = recipeService.getMaterial(recipe_id);
		User user = accountService.findUserId(recipe.get().getUserId());
		int favorite = favoriteService.getFavorite(recipe_id);
		//モデルへの追加
		model.addAttribute("recipe",recipe.get());
		model.addAttribute("tags",recipeTags);
		model.addAttribute("procuderes",procuderes);
		model.addAttribute("materials",materials);
		model.addAttribute("user",user);
		model.addAttribute("favorite",favorite);
		//ビュー数のカウント
		recipeService.addBrow(recipe_id);
		return "recipe/datail";
	}
}

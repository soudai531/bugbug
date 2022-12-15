package com.example.bugbug.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import com.example.bugbug.service.AccountService;
import com.example.bugbug.service.FavoriteService;
import com.example.bugbug.form.RecipeRegisterForm;
import com.example.bugbug.service.AuthService;
import com.example.bugbug.service.RecipeService;


@RequiredArgsConstructor
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final AccountService accountService;
    private final FavoriteService favoriteService;
	private final AuthService authService;
	//レシピ詳細画面の表示
	@GetMapping("recipes/{recipeId}")
	public String viewRecipeDetail(@PathVariable("recipeId") int recipeId, Model model) {
		//レシピ詳細情報の取得
		Optional<Recipe> recipe = recipeService.getRecipe(recipeId);
		List<Tag> recipeTags = recipeService.getRecipeTag(recipeId);
		List<RecipeProcedure> procuderes = recipeService.getProcedure(recipeId);
		List<RecipeMaterial> materials = recipeService.getMaterial(recipeId);
		User user = accountService.findUserId(recipe.get().getUserId());
		int favorite = favoriteService.getFavorite(recipeId);
		//モデルへの追加
		model.addAttribute("recipe", recipe.get());
		model.addAttribute("tags", recipeTags);
		model.addAttribute("procuderes", procuderes);
		model.addAttribute("materials", materials);
		model.addAttribute("user", user);
		model.addAttribute("favorite", favorite);
		//ビュー数のカウント
		recipeService.addBrow(recipeId);
		return "recipe";
	}

	
	// Form初期設定エリア
    @ModelAttribute
    public RecipeRegisterForm RecipeRegisterSetUpForm() {
        return new RecipeRegisterForm();
    }
    
	//レシピ登録画面表示
	@RequestMapping("/recipes/register/form")
	public String viewRegisterRecipeForm() {
	    //  ログイン状態判定
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
		return "register-recipe";
	}

    @Transactional
	@PostMapping("/recipes/register")
	public String saveRecipe(RecipeRegisterForm form,Model model) {
	    //  ログイン状態判定
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
        Recipe savedRecipe = recipeService.createRecipe(form);
        //画像の登録
        recipeService.saveRecipeImage(form.getRecipeImage(), savedRecipe.getRecipeId());
        //タグの登録
        recipeService.saveRecipeTag(savedRecipe.getRecipeId(),form.getTags());
        //材料の登録
        recipeService.saveMaterial(savedRecipe.getRecipeId(),form.getMaterials(),form.getAmounts());
        //手順の登録
        recipeService.saveProcedure(savedRecipe.getRecipeId(),form.getProcedureImages(),form.getContexts());
		return "redirect:/index";
	}
}

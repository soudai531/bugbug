package com.example.bugbug.controller;

import java.util.List;
import java.util.Optional;

import com.example.bugbug.entity.*;
import com.example.bugbug.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.bugbug.form.RecipeRegisterForm;


@RequiredArgsConstructor
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final AccountService accountService;
    private final FavoriteService favoriteService;
	private final AuthService authService;
	private final TagService tagService;

	//レシピ詳細画面の表示
	@GetMapping("recipes/{recipeId}")
	public String viewRecipeDetail(@PathVariable("recipeId") int recipeId, Model model) {
		//レシピ詳細情報の取得
		Optional<Recipe> recipe = recipeService.getRecipe(recipeId);
		// レシピIDからタグのリストを取得
		List<Tag> tags = tagService.getTagsForRecipeId(recipeId);
		List<RecipeProcedure> procuderes = recipeService.getProcedure(recipeId);
		List<RecipeMaterial> materials = recipeService.getMaterial(recipeId);
		User user = accountService.findUserId(recipe.get().getUserId());
		int favorite = favoriteService.getFavorite(recipeId);
		//モデルへの追加
		model.addAttribute("recipe", recipe.get());
		model.addAttribute("tags", tags);
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

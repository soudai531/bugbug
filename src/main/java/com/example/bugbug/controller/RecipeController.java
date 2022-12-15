package com.example.bugbug.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		model.addAttribute("recipe", recipe.get());
		model.addAttribute("tags", recipeTags);
		model.addAttribute("procuderes", procuderes);
		model.addAttribute("materials", materials);
		model.addAttribute("user", user);
		model.addAttribute("favorite", favorite);
		//ビュー数のカウント
		recipeService.addBrow(recipe_id);
		return "recipe/datail";
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

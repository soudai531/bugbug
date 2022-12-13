package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bugbug.common.DateComponent;
import com.example.bugbug.entity.Recipe;
import com.example.bugbug.form.RecipeRegisterForm;
import com.example.bugbug.service.AuthService;
import com.example.bugbug.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RecipeController {
	private final AuthService authService;
	private final RecipeService recipeService;
	
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

package com.example.bugbug.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@Autowired
    private HttpSession session;
	private final DateComponent dateComponent;
	private final AuthService authService;
	private final RecipeService recipeService;
	
	// Form初期設定エリア
    @ModelAttribute
    public RecipeRegisterForm RecipeRegisterSetUpForm() {
        return new RecipeRegisterForm();
    }
    
	//レシピ登録画面表示
	@RequestMapping("/recipes/new/register/form")
	public String viewNewRecipeForm() {
	//  ログイン状態判定
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
		return "recipe/register";
	}
	
	@PostMapping("/recipes/new/register")
	public String saveRecipe(RecipeRegisterForm form,Model model) {
	//  ログイン状態判定
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
        int image_blurred=0;
        //日付の取得
        Date date = dateComponent.getDate();
        //画像表示フラグの設定
        if(form.getImage_blurred()!=null) {
        	image_blurred = 1;
        }
        //登録するエンティティの作成
        Recipe recipe = new Recipe(null,(Integer) session.getAttribute("user_id"),form.getName()
        					,null,form.getExplan(),form.getPoint(),image_blurred,0,date,0);
        
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        
        
        //画像の登録
        recipeService.saveRecipeImage(form.getImage(), savedRecipe.getRecipeId());
        //タグの登録
        recipeService.saveTag(savedRecipe.getRecipeId(),form.getTags());
        //材料の登録
        recipeService.saveMaterial(savedRecipe.getRecipeId(),form.getMaterials(),form.getAmounts());
        //手順の登録
        recipeService.saveProcedure(savedRecipe.getRecipeId(),form.getDatail_images(),form.getContexts());
		return "index";
	}
}

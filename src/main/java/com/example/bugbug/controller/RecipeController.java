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
        Date date = dateComponent.getDate();
        if(form.getImage_blurred()!=null) {
        	image_blurred = 1;
        }
        
        Recipe recipe = new Recipe((Integer) null,(Integer) session.getAttribute("user_id"),form.getName()
        					,null,form.getExplan(),form.getPoint(),image_blurred,0,date,0);
        
        recipeService.save();
        
		return "";
	}
}

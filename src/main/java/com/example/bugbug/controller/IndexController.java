package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import com.example.bugbug.service.AuthService;
import com.example.bugbug.service.RecipeService;
import com.example.bugbug.service.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final RecipeService recipeService;
    private final AuthService authService;

    @Autowired
    private HttpSession session;

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String viewIndex(Model model){
    	//ログイン状態判定
    	boolean loginState = false;
    	if(authService.isLogin()) {
    		loginState = true;
    	}
    	model.addAttribute("loginState", loginState);
        model.addAttribute("session_name",session.getAttribute("user_name"));
        model.addAttribute("user_id",session.getAttribute("user_id"));
        List<RecipeDto> recipes = recipeService.getAllRecipe();
        model.addAttribute("recipes", recipes);
        return "index";
    }
}

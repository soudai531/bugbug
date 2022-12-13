package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import com.example.bugbug.service.RecipeService;
import com.example.bugbug.service.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final RecipeService recipeService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String viewIndex(Model model){
        model.addAttribute("session_name",session.getAttribute("user_name"));
        model.addAttribute("user_id",session.getAttribute("user_id"));
        List<RecipeDto> recipes = recipeService.getAllRecipe();
        model.addAttribute("recipes", recipes);
        return "index";
    }
}

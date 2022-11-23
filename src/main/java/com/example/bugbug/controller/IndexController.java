package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import com.example.bugbug.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

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
        recipeService.getAllRecipe();
        return "index";
    }
}

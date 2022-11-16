package com.example.bugbug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bugbug.form.InputForm;

@Controller
public class UserController {
	//Form初期設定エリア
	@ModelAttribute
	public InputForm InputSetUpForm() {
		return new InputForm();
	}
	
	
	@GetMapping("sinup/form")
	public String viewAcountForm() {
		return "sinup";
	}
	
	@PostMapping("sinup")
	public String createAcount() {
		
		return "sinup";
	}
	
	
}

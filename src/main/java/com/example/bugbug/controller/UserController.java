package com.example.bugbug.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bugbug.entity.Users;
import com.example.bugbug.form.LoginForm;
import com.example.bugbug.service.UserService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class UserController {
	//インスタンス作成部分
	private final UserService service;
	final HttpSession session;
	
	//Form初期設定エリア
	@ModelAttribute
	public LoginForm LoginSetUpForm() {
		return new LoginForm();
	}
	
	//ログイン画面への遷移
		@GetMapping("index")
		public String viewIndex() {
			return "index";
		}
		
		//ログイン画面遷移
		@RequestMapping(value="login/form")
		public String viewLoginForm() {
			return "login";
		}
		
		//ログイン処理
		
		@PostMapping(value="index",params="com")
		public String authLogin(@Validated LoginForm f,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
			
			//メールで検索
			List<Users> list = service.findMail(f.getMail());
			//メールとパスワードが正しいとき
			if(!list.isEmpty() && service.match(list.get(0).getPass(), f.getPass())) {
				//sessionnに値を登録
				session.setAttribute("user_id", list.get(0).getUser_id());
				session.setAttribute("user_name", list.get(0).getName());
				model.addAttribute("msg","ログイン成功");
				return "index";
			}else {
				redirectAttributes.addFlashAttribute("msg","メールアドレスかパスワードが違います");
				return "redirect:/login/form";
			}
			
			
		}
}

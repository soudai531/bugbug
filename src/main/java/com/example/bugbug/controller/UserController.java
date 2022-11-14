package com.example.bugbug.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bugbug.entity.User;
import com.example.bugbug.form.LoginForm;
import com.example.bugbug.service.UserService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class UserController {
	//インスタンス作成部分
	private final UserService service;
	final HttpSession session;
	
	//ログイン画面への遷移
		@GetMapping("index")
		public String indexView() {
			return "index";
		}
		
		//ログイン処理
		@PostMapping(value="login",params="com")
		public String login(@Validated LoginForm f,BindingResult bindingResult,Model model) {
			//バリデーション
			if(bindingResult.hasErrors()) {
				return "index";
			}
			//メールで検索
			List<User> list = service.findMail(f.getMail());
			//メールとパスワードが正しいとき
			if(!list.isEmpty() && service.match(list.get(0).getPass(), f.getPass())) {
				//sessionnに値を登録
				session.setAttribute("user_id", list.get(0).getUser_id());
				session.setAttribute("user_name", list.get(0).getUser_name());
				return "index";
			}else {
				model.addAttribute("msg","メールアドレスかパスワードが違います");
				return "login";
			}
			
			
		}
}

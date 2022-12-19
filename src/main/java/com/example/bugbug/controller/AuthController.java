package com.example.bugbug.controller;

import com.example.bugbug.entity.User;
import com.example.bugbug.form.LoginForm;
import com.example.bugbug.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

// ログイン処理のコントローラー
@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService service;
    @Autowired
    private HttpSession session;

    @ModelAttribute
    public LoginForm LoginSetUpForm() {
        return new LoginForm();
    }

    // ログイン画面遷移
    @RequestMapping(value = "login/form")
    public String viewLoginForm(RedirectAttributes redirectAttributes,Model model) {
    	//ログイン状態判定
    	boolean loginState = false;
    	if(service.isLogin()) {
    		loginState = true;
    	}
    	model.addAttribute("loginState", loginState);
        return "login";
    }

    // ログイン処理
    @PostMapping(value = "login")
    public String authLogin(@Validated LoginForm f, BindingResult bindingResult, Model model,
                            RedirectAttributes redirectAttributes) {
        // メールで検索
        List<User> list = service.findMail(f.getMail());
        // メールとパスワードが正しいとき
        if (!list.isEmpty() && service.match(list.get(0).getPassword(), f.getPassword())) {
            // sessionに値を登録
            session.setAttribute("user_id", list.get(0).getUserId());
            session.setAttribute("user_name", list.get(0).getName());
            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("msg", "メールアドレスかパスワードが違います");
            return "redirect:/login/form";
        }
    }
}

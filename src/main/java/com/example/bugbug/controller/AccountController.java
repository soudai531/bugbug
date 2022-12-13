package com.example.bugbug.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bugbug.common.DateComponent;
import com.example.bugbug.entity.User;
import com.example.bugbug.form.UserRegisterForm;
import com.example.bugbug.service.AccountService;
import com.example.bugbug.validator.MailValidator;
import com.example.bugbug.validator.PasswordValidator;

import lombok.RequiredArgsConstructor;

// アカウント登録用のコントローラー
@RequiredArgsConstructor
@Controller
public class AccountController {
	private final DateComponent dateComponent;
    private final AccountService accountservice;
    private final PasswordValidator passValidator;
    private final MailValidator mailValidator;

    @Autowired
    private HttpSession session;

    // Form初期設定エリア
    @ModelAttribute
    public UserRegisterForm InputSetUpForm() {
        return new UserRegisterForm();
    }

    // 自作バリデーションの導入
    @InitBinder("inputForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(passValidator);
        webDataBinder.addValidators(mailValidator);
    }

    // 新規登録フォームへの遷移
    @RequestMapping("sinup/form")
    public String viewAcountForm() {
        return "sinup";
    }

    // 新規アカウント登録処理
    @PostMapping("sinup")
    public String createAcount(@Validated UserRegisterForm f, BindingResult bindingResult, Model model) {
        // validation
        if (bindingResult.hasErrors()) {
            return "sinup";
        }
        // パスワードのハッシュ化
        String hash = accountservice.hash(f.getPassword());
        // 現在の日付を取得
        Date date = dateComponent.getDate();
        // 登録用のエンティティの定義
        User user = new User(null, f.getName(), null, f.getMail(), hash, date);
        // 登録処理
        accountservice.addUser(user);
        // ユーザーIDの取得
        List<User> list = accountservice.findMail(f.getMail());
        // セッションへの追加
        session.setAttribute("user_id", list.get(0).getUserId());
        session.setAttribute("user_name", f.getName());
        // トップページにリダイレクト
        return "redirect:/index";
    }
}

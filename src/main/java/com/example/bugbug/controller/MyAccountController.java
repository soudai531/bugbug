package com.example.bugbug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

// マイアカウント関係のコントローラー
@RequiredArgsConstructor
@Controller
public class MyAccountController {

    @Autowired
    private HttpSession session;

    @RequestMapping("mypage")
    public String viewMypage(Model model){
        if(session.getAttribute("user_id") == null){
            System.out.println(session.getAttribute("user_id"));
            return "redirect:/login";
        }

        return "mypage";
    }

    @RequestMapping("logout")
    public String logout(){
        return "index";
    }

    /**
     * ユーザーアイコンの登録（変更も兼ねる）
     * @param userId
     * @return
     */
    @PostMapping ("/users/{userId}/user-icon/update")
    public String updateUserIcon(@PathVariable int userId){
        // Todo ユーザー認証
        if(session.getAttribute("userId") != null){
            System.out.println(userId);
        }else{
            System.out.println("ログインしていません");
        }
//        return "redirect:/index";
        return "redirect:/mypage";
    }
}

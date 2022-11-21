package com.example.bugbug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

// マイアカウント関係のコントローラー
@RequiredArgsConstructor
@Controller
public class MyAccountController {

    @Autowired
    private HttpSession session;

    @RequestMapping("logout")
    public String logout(){
        return "index";
    }
}

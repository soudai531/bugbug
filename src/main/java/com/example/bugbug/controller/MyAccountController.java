package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;

// マイアカウント関係のコントローラー
@RequiredArgsConstructor
@Controller
public class MyAccountController {

    @Autowired
    private HttpSession session;

    @RequestMapping("users/**/logout")
    public String logput(SessionStatus sessionStatus) {
		 //sessionに登録さてている情報を削除
		 session.removeAttribute("user_id");
		 session.removeAttribute("user_name");
		 session.invalidate();
		 //sessionのリセット
		 sessionStatus.setComplete();
		 return "index";
	 }
}

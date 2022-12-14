package com.example.bugbug.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@RestController
public class FrontRestController {
    @Autowired
    private HttpSession session;

    /**
     * ログインかどうかを返す
     */
    @GetMapping("/is-login")
    public Boolean getUserSession() {
        return session.getAttribute("user_id") != null;
    }
}

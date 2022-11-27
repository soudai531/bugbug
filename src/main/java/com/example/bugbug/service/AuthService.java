package com.example.bugbug.service;

import com.example.bugbug.entity.User;

import java.util.List;

public interface AuthService {

    // メールでユーザー検索
    List<User> findMail(String mail);
    // パスワードのチェック
    Boolean match(String inputPass, String password);
}

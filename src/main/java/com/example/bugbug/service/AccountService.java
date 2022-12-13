package com.example.bugbug.service;

import java.util.List;

import com.example.bugbug.entity.User;

public interface AccountService {

    // ユーザー登録
    void addUser(User user);

    // メールでユーザー検索
    List<User> findMail(String mail);

    // ハッシュ化
    String hash(String pass);

    

    // ユーザー情報1件取得
    User findUserId(int id);
}

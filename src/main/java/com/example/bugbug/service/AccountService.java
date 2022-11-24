package com.example.bugbug.service;

import com.example.bugbug.entity.Users;

import java.sql.Date;
import java.util.List;

public interface AccountService {

    // ユーザー登録
    void addUser(Users user);

    // メールでユーザー検索
    List<Users> findMail(String mail);

    // ハッシュ化
    String hash(String pass);

    // 日付取得
    Date getDate();
}

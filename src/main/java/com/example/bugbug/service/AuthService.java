package com.example.bugbug.service;

import com.example.bugbug.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface AuthService {

    // メールでユーザー検索
    List<Users> findMail(String mail);
    // パスワードのチェック
    Boolean match(String inputPass, String pass);
}

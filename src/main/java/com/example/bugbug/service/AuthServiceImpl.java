package com.example.bugbug.service;

import com.example.bugbug.entity.Users;

import java.util.List;

public class AuthServiceImpl {
    // メールの取得
    @Override
    public List<Users> findMail(String mail) {
        return repository.findByMail(mail);
    }

}

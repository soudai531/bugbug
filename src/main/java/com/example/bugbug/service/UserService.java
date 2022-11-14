package com.example.bugbug.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bugbug.entity.User;
@Service
public interface UserService {
	//メールでユーザー検索
	List<User> findMail(String mail);
	//パスワードのチェック
	Boolean match(String inputPass,String pass);
}

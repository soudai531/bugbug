package com.example.bugbug.service;

import org.springframework.stereotype.Service;
import com.example.bugbug.entity.Users;
import java.sql.Date;
import java.util.List;

public interface UserService {

	// メールでユーザー検索
	List<Users> findMail(String mail);

	// パスワードのチェック
	Boolean match(String inputPass, String pass);

	// ユーザー登録
	void addUser(Users user);

	// ハッシュ化
	String hash(String pass);

	// 日付取得
	Date getDate();

}
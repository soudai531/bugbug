package com.example.bugbug.service;
import java.sql.Date;
import java.util.List;

import com.example.bugbug.entity.Users;

public interface UserService {

	//メールでユーザー検索
	List<Users> findMail(String mail);
	//ユーザー登録
	void addUser(Users user);
	//ハッシュ化
	String hash(String pass);
	//日付取得
	Date getDate();
}

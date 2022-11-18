package com.example.bugbug.service;

import java.sql.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bugbug.entity.Users;
import com.example.bugbug.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	// repositoryを使えるようにする
	private final UserRepository repository;

	// メールの取得
	@Override
	public List<Users> findMail(String mail) {
		return repository.findByMail(mail);
	}

	// ユーザーの登録
	@Override
	public void addUser(Users user) {
		repository.save(user);
	}

	// ハッシュ化
	@Override
	public String hash(String pass) {
		// ハッシュ化用のクラス
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// ハッシュ化
		String hash = bcpe.encode(pass);
		return hash;
	}

	// 日付の取得
	@Override
	public Date getDate() {
		// 日付の取得
		Date date = new Date(new java.util.Date().getTime());
		return date;
	}

	// パスワードチェック
	@Override
	public Boolean match(String inputPass, String pass) {
		// ハッシュ化用のクラス
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// パスワードがあっていた場合
		if (bcpe.matches(pass, inputPass)) {
			return true;
		}
		return false;
	}
}

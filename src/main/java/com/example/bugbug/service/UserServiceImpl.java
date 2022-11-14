package com.example.bugbug.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bugbug.entity.User;
import com.example.bugbug.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	//repositoryを使えるようにする
	private final UserRepository repository;
	
	@Override
	public List<User> findMail(String mail) {
		return repository.findByMail(mail);
	}
	
	//パスワードチェック
	@Override
	public Boolean match(String inputPass,String pass) {
	//ハッシュ化用のクラス
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		//パスワードがあっていた場合
		if (bcpe.matches(pass, inputPass) ){
			return true;
		}
		return false;
	}

}

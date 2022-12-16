package com.example.bugbug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bugbug.entity.User;
import com.example.bugbug.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
    private final UserRepository userRepository;

    // メールの取得
    @Override
    public List<User> findMail(String mail) {
        return userRepository.findByMail(mail);
    }

    // ユーザーの登録
    @Override
    public void addUser(User user) {
        userRepository.save(user);
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

    

    // ユーザー情報1件取得
    @Override
    public User findUserId(int id){
        Optional<User> user= userRepository.findById(id);
        return user.get();
    }
}

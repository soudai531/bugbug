package com.example.bugbug.service;

import com.example.bugbug.entity.Users;
import com.example.bugbug.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository repository;
    @Autowired
    private HttpSession session;

    // メールの取得
    @Override
    public List<Users> findMail(String mail) {
        return repository.findByMail(mail);
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

    /**
     * ログイン中かどうかを返すメソッド
     * @return Boolean
     */
    @Override
    public Boolean isLogin(){
        Object userId = session.getAttribute("user_id");
        return userId != null;
    }


}

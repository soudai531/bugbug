package com.example.bugbug.service;

import org.springframework.web.multipart.MultipartFile;

public interface MyAccountService {
    String saveUserIcon(MultipartFile file, int userId);

    //アイコンのファイル名を取得
    String getMyIcon();
    
    /** 下記2つ仮で置いてます。後で消してください */
    //メールアドレスを取得
    String getMyMail();
    
    //ユーザーネームを取得
    String getMyUsername();
}

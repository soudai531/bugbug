package com.example.bugbug.service;

import org.springframework.web.multipart.MultipartFile;

public interface MyAccountService {
    String saveUserIcon(MultipartFile file, int userId);

    //アイコンのファイル名を取得
    String getIcon(int userId);
}

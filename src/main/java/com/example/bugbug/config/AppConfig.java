package com.example.bugbug.config;

import lombok.Data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

// 画像保存先設定クラス
@Data
public class AppConfig {
    //画像の保存ディレクトリフィールド
    private Map<String, File> dirMap = new HashMap<>();

    // Mapにkeyと絶対パスを設定
    public void setDirMap(String dirName, File file){
        dirMap.put(dirName, file);
    }
}
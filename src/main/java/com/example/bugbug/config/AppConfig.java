package com.example.bugbug.config;

import lombok.Data;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AppConfig {
    //Fileクラスはパス情報を保持したり、ファイル操作やディレクトリ操作するためのクラス。
    private Map<String, File> dirMap = new HashMap<>();

    public void setDirMap(String dirName, File file){
        dirMap.put(dirName, file);
    }
}
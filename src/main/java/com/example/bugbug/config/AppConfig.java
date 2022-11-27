package com.example.bugbug.config;

import lombok.Data;

import java.io.File;

@Data
public class AppConfig {
    //Fileクラスはパス情報を保持したり、ファイル操作やディレクトリ操作するためのクラス。
    private File imageDir;
}
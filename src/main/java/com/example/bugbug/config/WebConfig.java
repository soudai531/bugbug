package com.example.bugbug.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Javaコンフィグレーションクラスを作成。→リソースハンドラ（SpringMVC内蔵の仕組み）が設定できる
public class WebConfig implements WebMvcConfigurer {

    // 画像保存先設定クラス
    @Autowired
    private AppConfig appConfig;

    //リソースハンドラの設定（追加）内容。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //画像の親フォルダの絶対パスをURIに変換
        String parentDirUri = appConfig.getDirMap().get("images").toURI().toString();
        //「/images/以下のパスがリクエストされたら」「imageDirにある対応ファイルを使用する」という設定
        registry.addResourceHandler("/images/**").addResourceLocations(parentDirUri);
    }
}

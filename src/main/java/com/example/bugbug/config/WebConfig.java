package com.example.bugbug.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Javaコンフィグレーションクラスを作成。→リソースハンドラ（SpringMVC内蔵の仕組み）が設定できる。＝自分でファイルごとにハンドラメソッドを作成しなくてよくなる。
public class WebConfig implements WebMvcConfigurer {

    @Autowired //@Beanなどをつけて事前設定されたインスタンスを使用するには@Autowiredが必要（AppConfigクラスが使えるようになる）
    private AppConfig appConfig;

    //リソースハンドラの設定（追加）内容。
    @Override //addResourceHandlersのオーバーライドをしJavaプログラムとして記述。「ソース→メソッドのオーバーライド→addResourceHandlersを選択」
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //ファイルの場所はURI形式で渡す必要があるため、FileクラスのtoURIメソッドを使用して変換
        String imageDirUri = appConfig.getDirMap().get("images").toURI().toString();
        //「/images/以下のパスがリクエストされたら」「imageDirにある対応ファイルを使用する」という設定
        registry.addResourceHandler("/images/**").addResourceLocations(imageDirUri);
    }
}

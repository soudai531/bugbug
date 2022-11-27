package com.example.bugbug;

import com.example.bugbug.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class BugbugApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugbugApplication.class, args);
	}

	@Bean//@Beanアノテーションを付けたメソッドを定義しておくことでSpring Frameworkがオブジェクトを登録して後で使える
	public AppConfig appConfig() {

		// 起動時のディレクトリをAppConfigのimageDirフィールドに保持しておく
		File imageDir = new File("images");
		imageDir = imageDir.getAbsoluteFile();

		// imagesフォルダがなかったら作成する
		if(!imageDir.exists()) {
			imageDir.mkdir();
		}
		AppConfig appConfig = new AppConfig();
		appConfig.setImageDir(imageDir);
		System.out.println(imageDir);
		return appConfig;
	}

}

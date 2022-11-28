package com.example.bugbug;

import com.example.bugbug.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BugbugApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugbugApplication.class, args);
	}

	// 画像の保存先の設定Bean
	@Bean
	public AppConfig appConfig() {

		// フォルダの相対パス
		final Map<String,String> dirPath = new HashMap<>(){
			{
				put("images", "images");
				put("user-icon", "images/user-icons");
				put("recipe-image", "images/recipe-images");
				put("recipe-procedure-images", "images/recipe-procedure-images");
			}
		};

		AppConfig appConfig = new AppConfig();
		// 絶対パスの取得し、AppConfigのフィールドに設定、ディレクトリの生成
		dirPath.forEach((key, path) -> {
			// 起動時のディレクトリのフォルダをAppConfigのフィールドに保持しておく
			File dir = new File(path);
			// 絶対パスでフォルダを取得し直す
			File dirAbs = dir.getAbsoluteFile();
			// appConfigに保存する
			appConfig.setDirMap(key, dirAbs);
			// フォルダがなかったら作成する
			if(!dirAbs.exists()) {
				dirAbs.mkdir();
			}
		});
		return appConfig;
	}
}

package com.example.bugbug.controller;
import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bugbug.common.DateComponent;
import com.example.bugbug.entity.Favorite;
import com.example.bugbug.service.FavoriteService;

import lombok.RequiredArgsConstructor;

//お気に入り機能用のコントローラー
@RequiredArgsConstructor
@Controller
public class FavoriteController {

	@Autowired
	private HttpSession session;
	private final FavoriteService favoriteService;
	private final DateComponent dateComponent;
	
	//お気に入りに登録
	@PostMapping("/recipe/favorite/add/*")
	public void addFavorite(int recipe_id) {
		Date date = dateComponent.getDate();
		Favorite favorite = new Favorite(null,(Integer) session.getAttribute("user_id"),recipe_id,date);
		favoriteService.addFavorite(favorite);
		
		//favoriteService.countFavorite(recipe_id);
	}
	
	//お気に入りから削除
	@PostMapping("/recipe/favorite/delete/*")
	public void deleteFavorite(@RequestParam int recipId) {
		favoriteService.deleteFavorite((Integer) session.getAttribute("user_id"),recipId);
		
		 //favoriteService.countFavorite(recipe_id);
	}
	
}

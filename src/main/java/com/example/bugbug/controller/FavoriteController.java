package com.example.bugbug.controller;
import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/recipe/favorite/add/*")
	public int addFavorite(int recipe_id) {
		Date date = dateComponent.getDate();
		Favorite favorite = new Favorite(null,(Integer) session.getAttribute("user_id"),recipe_id,date);
		favoriteService.addFavorite(favorite);
		
		return favoriteService.countFavorite(recipe_id);
	}
	
}

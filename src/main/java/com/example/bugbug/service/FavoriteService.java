package com.example.bugbug.service;

import com.example.bugbug.entity.Favorite;

public interface FavoriteService {
	
	//お気に入りの登録
	void addFavorite(Favorite favorite);
	
	//お気に入り数の取得
	public int countFavorite(int recipe_id);
}

package com.example.bugbug.service;

import com.example.bugbug.entity.Favorite;

public interface FavoriteService {
	
	//レシピのお気に入り登録数の取得
	int getFavorite(int recipe_id);
	
	
	//お気に入り数の取得
	public int countFavorite(int recipe_id);
	
	//お気に入りに登録
	void addFavorite(Favorite favorite);
	
	//お気に入りから削除
	void deleteFavorite(int user_id ,int recipe_id);
	
}

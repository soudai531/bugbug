package com.example.bugbug.service;
import org.springframework.stereotype.Service;

import com.example.bugbug.entity.Favorite;
import com.example.bugbug.repository.FavoriteRepository;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class FavoriteServiceImpl implements FavoriteService{
	
	private final FavoriteRepository favoriteRepository;
	//レシピのお気に入り登録数の取得
	public int getFavorite(int recipe_id) {
		return favoriteRepository.countFavorite(recipe_id);
	}

	//お気に入り数の取得
	public int countFavorite(int recipe_id) {
		return favoriteRepository.countFavorite(recipe_id);
	}
	
	//お気に入りに登録
	public void addFavorite(Favorite favorite) {
		favoriteRepository.save(favorite);
	}
	
	//お気に入りから削除
	public void deleteFavorite(int user_id,int recipe_id) {
		favoriteRepository.delete(user_id,recipe_id);
	}
}

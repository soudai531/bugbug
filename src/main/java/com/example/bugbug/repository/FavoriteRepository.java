package com.example.bugbug.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bugbug.entity.Favorite;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {
    /**
     * レシピのお気に入り数を返す
     * @param recipeId レシピID
     * @return レシピのお気に入り合計数
     */
    @Query("SELECT count(*) FROM favorites WHERE recipe_id = :recipeId")
    int countFavorite(@Param("recipeId") int recipeId);
}

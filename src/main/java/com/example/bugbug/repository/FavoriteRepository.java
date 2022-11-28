package com.example.bugbug.repository;

import com.example.bugbug.entity.RecipeTag;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FavoriteRepository extends CrudRepository<RecipeTag, Integer> {
    @Query("SELECT count(*) FROM favorites WHERE recipe_id = :recipe_id")
    int countFavorite(int recipe_id);
}

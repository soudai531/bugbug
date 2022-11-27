package com.example.bugbug.repository;

import com.example.bugbug.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAll();
}

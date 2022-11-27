package com.example.bugbug.repository;

import com.example.bugbug.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipesRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAll();
}

package com.example.bugbug.repository;

import com.example.bugbug.entity.Recipes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RecipesRepository extends CrudRepository<Recipes, Integer> {

    List<Recipes> findAll();
}

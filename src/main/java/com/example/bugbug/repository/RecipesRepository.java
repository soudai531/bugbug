package com.example.bugbug.repository;

import com.example.bugbug.entity.Recipes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends CrudRepository<Recipes, Integer> {
}

package com.example.bugbug.repository;

import com.example.bugbug.entity.RecipeTags;
import com.example.bugbug.entity.RecipeTagsKey;
import org.springframework.data.repository.CrudRepository;

public interface RecipeTagsRepository  extends CrudRepository<RecipeTags, RecipeTagsKey> {
}

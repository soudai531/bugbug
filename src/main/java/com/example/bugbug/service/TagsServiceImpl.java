package com.example.bugbug.service;

import com.example.bugbug.entity.RecipeTags;
import com.example.bugbug.entity.Tags;
import com.example.bugbug.repository.TagsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TagsServiceImpl implements TagsService {

    private TagsRepository tagsRepository;


    @Override
    public List<Tags> getTags(List<RecipeTags> recipeTags) {
        List<Tags> tags = new ArrayList<>();
        // タグを取得
        recipeTags.forEach(recipeTag -> tags.add(tagsRepository.findById(recipeTag.getRecipeTagId()).get()));
        return tags;
    }
}

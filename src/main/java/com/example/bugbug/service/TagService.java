package com.example.bugbug.service;

import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;

import java.util.List;

public interface TagService {
    /**
     * レシピに紐づいているタグの情報をまとめて取得
     * @param recipeTags
     * @return
     */
    List<Tag> getTags(List<RecipeTag> recipeTags);
}

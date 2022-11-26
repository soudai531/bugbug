package com.example.bugbug.service;

import com.example.bugbug.entity.RecipeTags;
import com.example.bugbug.entity.Tags;

import java.util.List;

public interface TagsService {
    /**
     * レシピに紐づいているタグの情報をまとめて取得
     * @param recipeTags
     * @return
     */
    List<Tags> getTags(List<RecipeTags> recipeTags);
}

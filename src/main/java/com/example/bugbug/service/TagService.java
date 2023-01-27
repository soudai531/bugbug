package com.example.bugbug.service;

import java.util.List;

import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;

public interface TagService {
    /**
     * レシピに紐づいているタグの情報をまとめて取得
     * @param recipeTags
     * @return
     */
    List<Tag> getTags(List<RecipeTag> recipeTags);
    
    
    //タグの操作
    public void saveTag(String name);
    
    //タグ名からIDの取得
    Tag getTagByName(String name);

    // IDからタグ情報を取得
    Tag getTagById(int tagId);
}

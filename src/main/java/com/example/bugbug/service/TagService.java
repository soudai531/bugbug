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
    
    //タグの登録
    Tag saveTag(Tag tag);
    
    //IDの取得
    int getId(String name);
    
   
}

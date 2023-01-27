package com.example.bugbug.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.repository.TagRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;




    /**
     * レシピタグのリストを受け取りタグ情報をリストで返す
     * @param recipeTags
     * @return
     */
    @Override
    public List<Tag> getTags(List<RecipeTag> recipeTags) {
        List<Tag> tags = new ArrayList<>();
        // タグを取得
        recipeTags.forEach(recipeTag -> tags.add(tagRepository.findById(recipeTag.getTagId()).get()));
        return tags;
    }
    
    //タグが存在しなかったら登録かつタグIDの取得
    @Override
    public void saveTag(String name) {
    	//タグが存在しない時
    	if(!tagRepository.existsByName(name)) {
    		//タグの登録
    		tagRepository.save(new Tag(null,name,0));
    	}
    }
    
    //名前からタグを取得
    @Override
    public Tag getTagByName(String name) {
    	 return tagRepository.findByName(name);
    }

    /**
     * タグIDからタグエンティティを取得
     * @param tagId
     * @return
     */
    @Override
    public Tag getTagById(int tagId) {
        return tagRepository.findById(tagId);
    }
}

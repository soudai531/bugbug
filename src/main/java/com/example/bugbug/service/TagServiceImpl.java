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
    //タグの保存
    @Override
    public  Tag saveTag(Tag tag) {
    	return tagRepository.save(tag);
    }
    //IDの取得
    @Override
    public int getId(String name) {
    	//タグが存在しない時
    	if(!tagRepository.existsByName(name)) {
    		//タグの登録
    		tagRepository.save(new Tag(null,name,0));
    	}
    	//IDの取得
    	Tag tag = tagRepository.findByName(name);
    	return tag.getTagId();
    }
}

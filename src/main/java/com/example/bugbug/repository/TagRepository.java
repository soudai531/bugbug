package com.example.bugbug.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bugbug.entity.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {
	
	//名前でタグを検索
    Tag findByName(String name);
    //タグの存在チェック
    boolean existsByName(String name);
}

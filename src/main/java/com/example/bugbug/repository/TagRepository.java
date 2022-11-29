package com.example.bugbug.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bugbug.entity.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    Tag findByName(String id);
    
    boolean existsByName(String name);
}

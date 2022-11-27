package com.example.bugbug.repository;

import com.example.bugbug.entity.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagsRepository  extends CrudRepository<Tag, Integer> {
    Tag findByName(String id);
}

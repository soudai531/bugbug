package com.example.bugbug.repository;

import com.example.bugbug.entity.Tags;
import org.springframework.data.repository.CrudRepository;

public interface TagsRepository  extends CrudRepository<Tags, Integer> {
    Tags findByName(String id);
}

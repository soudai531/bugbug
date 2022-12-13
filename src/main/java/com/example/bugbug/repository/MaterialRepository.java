package com.example.bugbug.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bugbug.entity.RecipeMaterial;

public interface MaterialRepository extends CrudRepository<RecipeMaterial, Integer> {

}

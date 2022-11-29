package com.example.bugbug.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bugbug.entity.RecipeProcedure;

public interface ProcedureRepository extends CrudRepository<RecipeProcedure, Integer> {

}

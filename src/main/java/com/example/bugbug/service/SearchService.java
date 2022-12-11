package com.example.bugbug.service;

import com.example.bugbug.service.dto.RecipeDto;

import java.util.List;
import java.util.Set;

public interface SearchService {
    List<RecipeDto> searchKeyword(String keyword);
}

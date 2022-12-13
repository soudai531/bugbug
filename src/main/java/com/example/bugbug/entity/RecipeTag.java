package com.example.bugbug.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("recipe_tags")
public class RecipeTag {
	@Id
    @Column("recipe_tag_id")
    private int recipeTagId;
    @Column("recipe_id")
    private int recipeId;
    @Column("tag_id")
    private int tagId;
    private int deleted;
}

package com.example.bugbug.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("recipe_tags")
public class RecipeTags {
    @Id
    private int recipe_id;
    @Id
    private int tag_id;
    private int deleted;
}

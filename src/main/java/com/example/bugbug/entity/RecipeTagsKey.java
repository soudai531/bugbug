package com.example.bugbug.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


/**
 * レシピタグテーブル主キー用クラス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeTagsKey {
    private int recipe_id;
    private int tag_id;
}

package com.example.bugbug.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("recipes")
public class Recipe {
	@Id
    @Column("recipe_id")
    private Integer recipeId;
    @Column("user_id")
    private Integer userId;
    private String name;
    private String image;
    @Column("explanation")
    private String explanation;
    private String point;
    @Column("image_blurred")
    private Integer imageBlurred;
    private Integer views;
    @Column("reg_date_on")
    private Date regDateOn;
    private Integer deleted;
}

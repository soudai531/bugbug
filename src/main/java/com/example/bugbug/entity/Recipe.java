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
    private int recipeId;
    @Column("user_id")
    private int userId;
    private String name;
    private String image;
    private String explan;
    private String point;
    @Column("image_blurred")
    private int imageBlurred;
    private int browes;
    @Column("reg_date_on")
    private Date regDateOn;
    private int deleted;
}

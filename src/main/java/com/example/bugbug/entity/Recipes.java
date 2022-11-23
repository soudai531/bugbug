package com.example.bugbug.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipes {
    private int recipe_id;
    private int user_id;
    private String name;
    private String image;
    private String explan;
    private String point;
    private int image_blurred;
    private int browes;
    private Date reg_date_on;
    private int deleted;
}

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
@Table("favorites")
public class Favorite {
	@Id
	@Column("favorite_id")
    private Integer favoriteId;
    @Column("user_id")
    private Integer userId;
    @Column("recipe_id")
    private Integer recipeId;
    @Column("reg_date_on")
    private Date regDateOn;
    
}

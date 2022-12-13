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
@Table("recipe_materials")
public class RecipeMaterial {
	@Id
	@Column("material_id")
	private Integer procedureId;
	@Column("recipe_id")
	private Integer recipeId;
	private String name;
	private String amount;
}

package com.example.bugbug.form;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RecipeRegisterForm {
	@NotBlank
	private String name;
	private List<String> tags;
	private MultipartFile recipeImage;
	private String explanation;
	private String point;
	private List<String> materials;
	private List<String> amounts;
	private List<MultipartFile> procedureImages;
	private List<String> contexts;
	private Integer image_blurred;
}

package com.example.bugbug.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginForm {
	@NotBlank
	@Size(max = 128)
	private String mail;
	@NotBlank
	@Size(max = 128)
	private String password;
}

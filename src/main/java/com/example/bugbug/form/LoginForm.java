package com.example.bugbug.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {
	@NotBlank
	private String mail;
	@NotBlank
	private String password;
}

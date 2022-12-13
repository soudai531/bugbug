package com.example.bugbug.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserRegisterForm {
	@Email
	private String mail;
	@NotBlank
	private String name;
	@Pattern(regexp="(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-z0-9]{6,}" )
	private String password;
	private String confirmPassword;//確認用パスワード
}

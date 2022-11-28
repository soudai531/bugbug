package com.example.bugbug.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.bugbug.form.UserRegisterForm;
//パスワード用のバリデーション
@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegisterForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//対象のフォームの取得
		UserRegisterForm form = (UserRegisterForm) target;
		//パスワードと確認用パスワードが違う場合
		if(!form.getPassword().equals(form.getConfirmPassword())) {
			errors.reject("com.example.demo.validator.PassValidator.message");
		}
	}
}
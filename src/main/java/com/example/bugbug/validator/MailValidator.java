package com.example.bugbug.validator;

import java.util.List;

import com.example.bugbug.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.bugbug.entity.User;
import com.example.bugbug.form.UserRegisterForm;

import lombok.RequiredArgsConstructor;
//メールのバリデーション
@RequiredArgsConstructor
@Component
public class MailValidator implements Validator {
	
	private final AccountService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegisterForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//対象のフォームの取得
		UserRegisterForm form = (UserRegisterForm) target;
		//メールの検索
		List<User> list = service.findMail(form.getMail());
		System.out.println(list);
		System.out.println("validate call");
		//メールがすでに登録されている場合
		if(!list.isEmpty()) {
			errors.reject("com.example.demo.validator.MailValidator.message");
		}
		
	}

}

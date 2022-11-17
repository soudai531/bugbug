package com.example.bugbug.validator;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.bugbug.entity.Users;
import com.example.bugbug.form.InputForm;
import com.example.bugbug.service.UserService;

import lombok.RequiredArgsConstructor;
//メールのバリデーション
@RequiredArgsConstructor
@Component
public class MailValidator implements Validator {
	
	private final UserService service;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO 自動生成されたメソッド・スタブ
		return InputForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO 自動生成されたメソッド・スタブ
		//対象のフォームの取得
		InputForm form = (InputForm) target;
		//メールの検索
		List<Users> list = service.findMail(form.getMail());
		//メールがすでに登録されている場合
		if(!list.isEmpty()) {
			errors.reject("com.example.demo.validator.MailValidator.message");
		}
		
	}

}

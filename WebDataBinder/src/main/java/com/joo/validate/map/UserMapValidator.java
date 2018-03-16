package com.joo.validate.map;

import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public class UserMapValidator implements Validator{
	
	private SpringValidatorAdapter sva;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		System.out.println("supports");
		System.out.println("supports");
		System.out.println("supports");
		System.out.println("supports");
		
		//uservo 로 사용 됬는지 체크(말 그대로 support 하는지 여부 체크 할려고)
		//return Map.class.isAssignableFrom(clazz);
		
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//값이 null, 0, 공백 허용 안함
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		
		
		
		@SuppressWarnings("unchecked")
		Map<String, Object> userParams = (Map<String, Object>)target;
		
		Object createDate = userParams.get("createDate");
		
		System.out.println("is String ? : "+createDate instanceof String);
		
		if (createDate == null || "".equals(createDate)) {
			//date validate
			errors.rejectValue("createDate", "badCreateDate");
		}
		
		/*
		 * 이메일 체크 로직.
		if (true) {
			//email validate
			errors.rejectValue("email", "badEmail");
		}
		*/
	}


}

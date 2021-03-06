package com.joo.validate.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		//uservo 로 사용 됬는지 체크(말 그대로 support 하는지 여부 체크 할려고)
		return UserVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//값이 null, 0, 공백 허용 안함
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		
		
		
		UserVo userVo = (UserVo)target;
		
		if (userVo.getCreateDate() == null || userVo.getCreateDate().toString().equals("")) {
			//date validate
			errors.rejectValue("createDate", "badCreateDate");
		}
		
		if (!userVo.isEnableEmail()) {
			//email validate
			errors.rejectValue("email", "badEmail");
		}
	}


}

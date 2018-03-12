package com.joo.validate;

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
		
		
		
		//그냥 널 체크 할 수도 있지만 동적으로 다른 방식으로 보여주는거
		UserVo userVo = (UserVo)target;
		
		if (userVo.getCreateDate().toString().equals("")) {
			errors.rejectValue("createDate", "badCreateDate");
		}
	}


}

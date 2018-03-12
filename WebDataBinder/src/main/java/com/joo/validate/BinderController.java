package com.joo.validate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/binder")
public class BinderController {
	
	private static final Logger logger = LoggerFactory.getLogger(BinderController.class);
	
	@RequestMapping(value="/")
	public String baseDir() {
		return "baseForm";
	}
	
	@RequestMapping(value="/submitData")
	public String submitData(HttpServletRequest req, @Valid UserVo userVo
			, Errors errors, BindingResult br) {
		
		/*
		 * 간단하게 가는 방법
		if(errors.hasErrors()) {
			return "baseForm"; 
		}
		*/
		
		//에러난 부분 확인할려고 쓰는거
		if(br.hasErrors()) {
			List<ObjectError> errs = br.getAllErrors();
			Map<String, Object> errModel = br.getModel();
			FieldError field = br.getFieldError();
			String filedName = field.getField();
			
			for(int i=0;i<errs.size();i++){
				ObjectError errMsg = errs.get(i);
				System.out.println(errMsg.getObjectName()+", "+filedName+errMsg.getDefaultMessage());
			}
			
			Iterator<String> errKeys = errModel.keySet().iterator();
			
			while(errKeys.hasNext()){
				String key = errKeys.next();
				
				System.out.println("key : "+key+", val : "+errModel.get(key));
			}
			
			
			//return "baseForm";
		}
		
		
		return "redirect:/";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserVoValidator());
	}
}

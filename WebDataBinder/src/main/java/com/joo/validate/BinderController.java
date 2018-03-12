package com.joo.validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
	
	@RequestMapping(value="/form")
	public String baseDir() {
		return "baseForm";
	}
	
	@RequestMapping(value="/submitData")
	public String submitData(HttpServletRequest req, @Valid UserVo userVo
			, BindingResult br) {
		
		//에러난 부분 확인할려고 쓰는거
		if(br.hasErrors()) {
			List<ObjectError> errs = br.getAllErrors();
			FieldError field = br.getFieldError();
			String filedName = field.getField();
			
			FieldError errOne = br.getFieldError();
			
			//하나만
			logger.error("first filed : "+errOne.getField()+", code : "+errOne.getCode());
			
			
			//전체
			for(int i=0;i<errs.size();i++){
				ObjectError errMsg = errs.get(i);
				//logger.error(errMsg.getObjectName()+", filed :"+filedName+", msg : "+errMsg.getDefaultMessage());
				
				
				logger.error("filedName : "+filedName+", code : "+errMsg.getCode());
			}
			
			/*
			 * 에러난 key 상세 정보 
			
			Map<String, Object> errModel = br.getModel();
			
			Iterator<String> errKeys = errModel.keySet().iterator();
			while(errKeys.hasNext()){
				String key = errKeys.next();
				
				System.out.println("key : "+key+", val : "+errModel.get(key));
			}
			*/
			
			//return "baseForm";
		}
		
		logger.info("validate success");
		
		return "redirect:/";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		//날짜 타입 converting 해주는거 셋팅
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
		
		binder.setValidator(new UserVoValidator());
	}
}

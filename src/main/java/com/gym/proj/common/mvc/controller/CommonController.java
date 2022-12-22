package com.gym.proj.common.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.exception.LogicException;
import com.gym.proj.common.exception.ResourceNotFoundException;

public class CommonController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected String JSON_VIEW = "jsonView";
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.info("start URI : " + request.getRequestURI());
		
		//TODO 삭제 필요
		ex.printStackTrace();
		
		String errName 	= ex.getClass().getName();
		String err 	= "000";
		String errMsg = null;
		String errLogMsg = "";
		
		//TODO 에러 처리
		if (ex instanceof LogicException) {
			String errorCode = ((LogicException)ex).getCode();	
			err = errorCode;
			errLogMsg = ex.getMessage();
		} else {
			err = "999";
			errMsg = "UNKNOWN_ERROR";
			errLogMsg = ex.getMessage();
		}
		
		ResultMap resultMap = new ResultMap();
		resultMap.setStatus(err);
		resultMap.setMsg(errMsg);
		
		String viewName;
		viewName = JSON_VIEW;
		
		ModelAndView  model = new ModelAndView(viewName);
		model.addAllObjects(resultMap);
		logger.error("["+errName+"] ["+err+"] ["+errMsg+"] [" +errLogMsg+"]");
		logger.info("end");
		return model;
	}

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView notFoundExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		ResultMap resultMap = new ResultMap();
		resultMap.setStatus("404");
		resultMap.setMsg("Page not found");
		
		ModelAndView mv = new ModelAndView("redirect:/korea/error/404");
		return mv;
	}
	
}

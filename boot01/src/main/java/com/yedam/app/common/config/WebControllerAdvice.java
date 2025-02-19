package com.yedam.app.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class WebControllerAdvice {
	
	@ModelAttribute("contextPath") // 
	public String contextPath(final HttpServletRequest request) {
		return request.getContextPath();
		//${pageContext.request.contextPath}
	}

	// 서버 내부의 예외 처리 
	/*
	@ExceptionHandler // 예외처리 
	public ResponseEntity<String> handle(IOException ex) {
		
	}
	
	*/
}
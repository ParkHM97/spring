package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Bean 등록, Web과 관련된 부분
public class URLController {
	@GetMapping("/urltest")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n Select - " + keyword;
	}
	
	@PostMapping("/urltest")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response : Post Method\n Select - " + keyword;
	}
}

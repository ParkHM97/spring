package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

// 0214 ~ 
@Controller
public class TestEmpController {
	//@RequestMapping(path="/test", method = RequestMethod.GET)
	@GetMapping("/test") // 권장하는 방식	
	@ResponseBody
	public String selectKeyword(EmpVO empVO) {
		String result = "Result : " + empVO.getEmployeeId();
		return result;
	}
}

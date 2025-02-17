package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	// Content-type : application/x-www-form-urlencoded
	// QueryString(질의문자열) : key=value&key=value&...
	// Method : 상관없음(json과 multipart는 post)
	
	// QueryString => 커맨드 객체 (어노테이션 X) : 객체 
	@RequestMapping(path="comobj", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}
	
	// QueryString => @RequestParam : 기본타입, 단일값
	@RequestMapping(path="reqparam", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam (@RequestParam Integer employeeId, // 필수 (int / double 사용 X) //@RequestParam이 붙은 값은 값이 반드시 있어야 함	
									// 값을 반드시 넘겨줘야 함 (넘기지 않으면 400 오류 발생)
											  String lastName,  // 생략 가능 
								@RequestParam (name="message", // name 값으로 ? 뒤에 입력해야 함 (msg는 X)
											   defaultValue="No message",  // @RequestParam(필수값) 붙어 있는데 값을 넘기지 않아도 오류 나지 않는 이유 => defaultValue
											   required=true) String msg) {// required = true일때만 default동작 
					// RequestParam으로 보내는 값은 최대 3개 
					String result="";
					result += "Path : /reqparam \n";
					result += "\t employee_id : " + employeeId; 
					result += "\t last_name : " + lastName;
					result += "\t message : " + msg;
					return result;
	}
	// PathVariable : 경로에 값을 포함하는 방식, 단일 값
	// Content-type 도 상관없음 / Method (get / post) 도 상관 없음 
	@RequestMapping("path/{id}") // => 방식 path/Hong, path/1234 / {id} 가 비어있으면 404
	// 중괄호 안에 선언된 변수에 값을 담겠다는 의미 
	@ResponseBody
	public String pathVariable(@PathVariable String id) {// 이 id라는 변수가 {id}에 담긴다. PathVariable 반드시 기재 
		String result = "";
		result += "path : /path/{id} \n";
		result += "\t id : " + id; // => payload로 데이터가 넘어가지 않음(경로명) / 보안 (경로에 숨김) 
		return result;
	}
	// Content-type : appication/JS
	//JOSN 포맷 => RequestBody JSON 포맷, 배열 OR
	// Method : POST, PUT
	// JSON : 객체 
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = " path : / resbody \n";
		result += "\t employee_id" + empVO.getEmployeeId();
		result += "\t last_name " + empVO.getLastName();
		return result;
		
	}
			
	// JSON : 배열
	@PostMapping("resbodyList") // single object만 처리 가능 (객체(한개) 배열(여러개) 한번에 X)
	// [] => 배열
	@ResponseBody
	public String requestBodyList
				  (@RequestBody List<EmpVO> list) {
//		ex) @RequestBody List<EmpVO> list > VO와 list 한번에 사용 불가 
//			@RequestBody EmpVO findVO (불가능) 한 번만 사용 가능
		String result = "path : /resbodyList \n";
		for(EmpVO empVO : list) {
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " + empVO.getLastName();
			result += "\n";
		}
		return result; // 화면 (서비스 실행하면 화면에 나오는 페이지) 
		// resolver : 경로와 확장자를 포함하고 있는 객체, 파일명만 제대로 지정하면 해당 객체가 완전한 경로를 수행함
	}
}

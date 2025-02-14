package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired // 필드 주입 => 단순 테스트용
	private EmpMapper empMapper;
	
	//@Test
	void selectTest() {
		List<EmpVO> list = empMapper.selectEmpList();
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	void infoTest() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		assertEquals("King", findVO.getLastName());
		// 첫번째 매개변수 : 기대하는 값
		// 두번째 매개변수 : 실제 값
		// => 두 개가 같으면 테스트 성공, 다르면 실패
	}
	
	//@Test
	void insertTest() throws ParseException {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setEmail("kang@daum.com");
		empVO.setJobId("SA_REP");
		
//		SimpleDateFormat sdf
//			= new SimpleDateFormat("yyMMdd");
//		Date date = sdf.parse("240501"); // 예외처리 : throws ParseException
//		
//		empVO.setHireDate(date);
//		
		int result = empMapper.insertEmpInfo(empVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void updateTest() {
		// 1) 단건조회 
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(217);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		// 2) 수정할 데이터 
		findVO.setLastName("Jang");
		findVO.setJobId(null);
		// 3) 수정 
		int result = empMapper.updateEmpInfo(findVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void deleteTest() {
		int result = empMapper.deleteEmpInfo(216);
		assertEquals(1, result);
	}

	@Test
	void selectKeyTest() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("Hong@google.com");
		empVO.setJobId("IT_PROG");
		// employeeId : null (insert 이전)
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println("====" + empVO.getEmployeeId());
		assertEquals(1, result);
	}
	
}

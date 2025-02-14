package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	// 사이트에서 제공하는 서비스
	// 전체조회
	public List<EmpVO> findAllEmp();
	// 단건조회
	public EmpVO findEmpInfo(EmpVO empVO);
	// 등록
	public int createEmpInfo(EmpVO empVO);
	// 수정 
	public Map<String, Object>modifyEmpInfo(EmpVO empVO);
	// 삭제
	public Map<String, Object>removeEmpInfo(int employeeId);
}

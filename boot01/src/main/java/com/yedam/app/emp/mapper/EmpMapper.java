package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// Mapper의 골격 혹은 구조를 의미
	// SELECT => 리턴타입 List or VO 클래스
	// 전체조회
	public List<EmpVO> selectEmpList();
	// 단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// DML => 리턴타입 int
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	// 수정
	public int updateEmpInfo(EmpVO empVO);
	// 삭제
	public int deleteEmpInfo(int empId);
}

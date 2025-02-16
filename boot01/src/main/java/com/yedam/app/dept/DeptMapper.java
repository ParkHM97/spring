package com.yedam.app.dept;

import java.util.List;

public interface DeptMapper {
	// 전체조회
	public List<DeptVO> selectDeptList();
	// 단건조회
	public DeptVO selectDeptInfo(DeptVO deptVO);
	// 등록
	public int insertDeptInfo(DeptVO deptVO);
	// 수정
	public int updateDeptInfo(DeptVO deptVO);
	// 삭제
	public int deleteDeptInfo(int deptId);
}

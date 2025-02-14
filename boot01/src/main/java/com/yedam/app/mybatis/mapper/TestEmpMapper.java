package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.mybatis.service.EmpInfo;

@Mapper
public interface TestEmpMapper {
	// EmpDAO => EmpMapper
	// 전체조회
	public List<EmpInfo> empList();
}

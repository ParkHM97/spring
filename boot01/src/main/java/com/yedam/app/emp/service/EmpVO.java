package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	// employee_id => employeeId
	private Integer employeeId;	// 사원번호
	private String firstName; 	// 이름
	private String lastName; 	// 성
	private String email;		// 이메일
	private String phoneNumber; // 연락처
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 날짜 포맷 
	private Date hireDate;		// 입사일자
	private String jobId;		// 업무
	private double salary; 		// 급여
	private double commissionPct; // 커미션
	private int managerId;		// 상사번호
	private int departmentId; 	// 부서번호
	


	
}

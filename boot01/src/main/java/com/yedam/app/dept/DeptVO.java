package com.yedam.app.dept;

import lombok.Data;

@Data
public class DeptVO {
	
	private Integer departmentId;
	private String departentName;
	private int managerId;
	private int locationId;
}

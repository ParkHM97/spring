package com.yedam.app.dept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

	private DeptMapper deptMapper;
	
	@Autowired
	DeptServiceImpl(DeptMapper deptMapper){
		this.deptMapper = deptMapper;
	}
	
	@Override
	public List<DeptVO> findAllDept() {
		return deptMapper.selectDeptList();
	}

	@Override
	public DeptVO findDeptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int createDeptInfo(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = deptMapper.updateDeptInfo(deptVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		return map;
	}

	@Override
	public Map<String, Object> removeDeptInfo(int departmentId) {
		Map<String, Object> map = new HashMap<>();
		int result = deptMapper.deleteDeptInfo(departmentId);
		if(result == 1) {
			map.put("departmentId", departmentId);
		}
		return map;
	}

}

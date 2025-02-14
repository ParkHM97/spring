package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;
@Service
public class AaaServiceImpl implements AaaService {
	private AaaMapper aaaMapper;
	
	@Autowired
	AaaServiceImpl(AaaMapper aaaMapper){
		this.aaaMapper = aaaMapper;
	}
	
	@Transactional // 트랜잭션 제어
	@Override
	public void aaaInsert() { // 아래의 모든 DML을 하나의 트랜잭션으로 묶는 어노테이션 > 하나만 성공하고 하나는 실패될 경우 모두 실패 처리
		aaaMapper.insert("101");
		aaaMapper.insert("a101"); // insert 실패 (aaa테이블에는 숫자 타입 컬럼만 있기 때문에)
		// 윗줄 값만 입력됨 (auto commit)
	}

}

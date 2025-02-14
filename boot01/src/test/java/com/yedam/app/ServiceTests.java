package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
public class ServiceTests {
	@Autowired
	private AaaService aaaService;
	
	@Test
	public void Transcational() {
		aaaService.aaaInsert();
	}
}

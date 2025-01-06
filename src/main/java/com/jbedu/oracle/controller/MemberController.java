package com.jbedu.oracle.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
	
	@Autowired //의존성 자동 주입
	private SqlSession sqlSession;
	
	

}

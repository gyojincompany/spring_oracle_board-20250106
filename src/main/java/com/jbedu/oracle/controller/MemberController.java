package com.jbedu.oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbedu.oracle.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired //의존성 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "memberJoin";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		int mage = Integer.parseInt(request.getParameter("mage")); //정수 타입으로 변환
		
		dao.joinMemberDao(mid, mpw, mname, memail, mage);
		
		return "joinOk";
	}

}

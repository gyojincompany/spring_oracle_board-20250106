package com.jbedu.oracle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		model.addAttribute("memberName", mname);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int loginFlag = dao.loginDao(mid, mpw); // 반환값이 1이면 로그인 성공, 0이면 로그인 실패
		
		if(loginFlag == 1) { //참이면 로그인 성공
			session.setAttribute("sessionId", mid);
			model.addAttribute("loginId", mid);
		} else {
			
			model.addAttribute("msg", "아이디 또는 비밀번호가 잘못 되었습니다. 다시 확인해주세요");
			model.addAttribute("url", "login");
			
			return "alert";
		}
		
		model.addAttribute("loginFlag", loginFlag); //로그인 성공 시 1이 전달, 실패 시 0이 전달
		
		return "loginOk";
	}
	
	
	
	
	
	

}

package com.jbedu.oracle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbedu.oracle.dao.BoardDao;
import com.jbedu.oracle.dao.MemberDao;
import com.jbedu.oracle.dto.MemberDto;

@Controller
public class BoardController {
	
	@Autowired //의존성 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/write_form")
	public String write_form(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		//로그인 상태라면 로그인한 아이디값이 반환, 로그인하지 않은 상태라면 null
//		System.out.println(sessionId);
		
		if(sessionId == null) { //로그인하지 않은 상태
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다!");
			model.addAttribute("url", "login");
			
			return "alert";
		}
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		MemberDto memberDto = dao.memberInfoDao(sessionId);
		
		model.addAttribute("loginId", sessionId);
		model.addAttribute("memberName", memberDto.getMname()); //로그인한 유저의 이름을 전송
		
		return "writeForm";
	}
	
	@RequestMapping(value = "/write") //게시판 글쓰기
	public String write(HttpServletRequest request, Model model) {
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		dao.writeDao(bid, bname, btitle, bcontent);
		
		return "redirect:list";
	}
	
	
	
	
	
	

}

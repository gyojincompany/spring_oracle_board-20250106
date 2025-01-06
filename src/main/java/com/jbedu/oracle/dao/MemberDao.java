package com.jbedu.oracle.dao;

import com.jbedu.oracle.dto.MemberDto;

public interface MemberDao {
	
	public int joinMemberDao(String mid, String mpw, String mname, String memail, int mage); //회원 가입
	public int loginDao(String mid, String mpw); //회원 로그인
	public int idCheckDao(String mid); //회원 가입여부 체크
	public MemberDto memberInfoDao(String mid); //아이디로 검색한 회원정보
	
}

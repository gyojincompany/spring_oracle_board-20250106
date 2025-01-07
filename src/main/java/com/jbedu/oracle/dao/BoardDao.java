package com.jbedu.oracle.dao;

import java.util.ArrayList;

import com.jbedu.oracle.dto.BoardDto;

public interface BoardDao {
	public void writeDao(String bid, String bname, String btitle, String bcontent); //게시판 글쓰기
	public ArrayList<BoardDto> listDao(); //게시판 모든 글 가져오기
}

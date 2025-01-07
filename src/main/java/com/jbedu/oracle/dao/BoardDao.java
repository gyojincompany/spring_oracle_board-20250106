package com.jbedu.oracle.dao;

import java.util.ArrayList;

import com.jbedu.oracle.dto.BoardDto;

public interface BoardDao {
	public void writeDao(String bid, String bname, String btitle, String bcontent); //게시판 글쓰기
	public ArrayList<BoardDto> listDao(); //게시판 모든 글 가져오기
	public BoardDto contentDao(String bnum); //게시글 1개 가져오기
	public void modifyDao(String bnum, String btitle, String bcontent); //글 수정하기
	public void uphitDao(String bnum); //조회수 증가
	public void deleteDao(String bnum); //글 삭제하기
	
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	번호 : ${boardDto.bnum}<br><br>
	아이디 : ${boardDto.bid}<br><br>
	이름 : ${boardDto.bname}<br><br>
	글제목 : ${boardDto.btitle}<br><br>
	글내용 : ${boardDto.bcontent}<br><br>
	조회수 : ${boardDto.bhit}<br><br>
	<hr>
	<input type="button" value="수정">
	<input type="button" value="삭제">
	<input type="button" value="글목록" onclick="javascript:location.href='list'"> 
</body>
</html>
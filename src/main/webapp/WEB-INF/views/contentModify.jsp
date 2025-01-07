<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 수정</title>
</head>
<body>
	<h2>글 내용 수정</h2>
	<hr>
	<form action="modifyOk">
	<input type="hidden" name="bnum" value="${boardDto.bnum}">
	번호 : ${boardDto.bnum}<br><br>
	아이디 : ${boardDto.bid}<br><br>
	이름 : ${boardDto.bname}<br><br>
	글제목 : <input type="text" value="${boardDto.btitle}" name="btitle" size="60"><br><br>
	글내용 : <textarea rows="5" cols="45" name="bcontent">${boardDto.bcontent}</textarea><br><br>
	조회수 : ${boardDto.bhit}<br><br>
	<hr>
	<input type="submit" value="수정완료">	
	<input type="button" value="수정취소" onclick="javascript:history.go(-1)">
	</form> 
</body>
</html>
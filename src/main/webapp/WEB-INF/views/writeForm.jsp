<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="write">
		아이디 : <input type="text" name="bid" value="${loginId}" readonly="readonly"><br><br>
		작성자 : <input type="text" name="bname" value="${memberName}" readonly="readonly"><br><br>
		글제목 : <input type="text" name="btitle" size="60"><br><br>
		글내용 : <textarea rows="5" cols="50" name="bcontent"></textarea><br><br>
		<input type="submit" value="글입력">
		<input type="button" value="취소" onclick="javascript:location.href='list'">
	</form>
</body>
</html>
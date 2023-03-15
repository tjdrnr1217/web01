<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글조회</title>
</head>
<body>
	<h3>게시글조회</h3>
	<hr />
	글번호 : ${brd.no}
	<br /> 글제목 : ${brd.title}
	<br /> 글내용 : ${brd.content}
	<br /> 작성자 : ${brd.writer}
	<br /> 조회수 : ${brd.hit}
	<br /> 날짜 : ${brd.regdate}
	<br />

	<hr />
	<a href="selectlist.do"><input type="button" value="목록" /></a>
	<input type="button" value="수정" />

	<form action="deleteone.do" method="post"
		style="display: inline-block;">
		<input type="text" name="no" value="${brd.no}" /> <input type="submit"
			value="삭제" />
	</form>

	<input type="submit" value="이전글" />

	<a href="selectone.do?no=${nno}"> <input type="button" value="다음글" /></a>

</body>
</html>

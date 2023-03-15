<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>회원가입</title>
	</head>
	
	<body>
		<div>
		<h3>회원가입</h3>
		<!--  joinaction.jsp 쪽으로 이동을 시켜라 -->
		<!--  post는 안보이게 7개의 이름 정보를 전송, get은 보이게 전송 -->
		<form action="joinaction.jsp" method="post">
		아이디 : <input type= "text" name = "id"/> <br /> <!-- <br>은 줄바꿈 -->
		암호 :<input type= "text" name = "pw"/> <br />
		암호확인 : <input type= "text" name = "pw2"/> <br />
		이름 : <input type= "text" name = "name"/> <br />
		나이 : <input type= "number" name = "age"/> <br />
		연락처 :<input type= "text" name = "phone"/> <br />
		성별 : <input type= "text" name = "gender"/> <br />
		<input type="submit" value = "회원가입" />
		</form>
		</div>
	</body>
</html>
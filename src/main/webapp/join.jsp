<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>ȸ������</title>
	</head>
	
	<body>
		<div>
		<h3>ȸ������</h3>
		<!--  joinaction.jsp ������ �̵��� ���Ѷ� -->
		<!--  post�� �Ⱥ��̰� 7���� �̸� ������ ����, get�� ���̰� ���� -->
		<form action="joinaction.jsp" method="post">
		���̵� : <input type= "text" name = "id"/> <br /> <!-- <br>�� �ٹٲ� -->
		��ȣ :<input type= "text" name = "pw"/> <br />
		��ȣȮ�� : <input type= "text" name = "pw2"/> <br />
		�̸� : <input type= "text" name = "name"/> <br />
		���� : <input type= "number" name = "age"/> <br />
		����ó :<input type= "text" name = "phone"/> <br />
		���� : <input type= "text" name = "gender"/> <br />
		<input type="submit" value = "ȸ������" />
		</form>
		</div>
	</body>
</html>
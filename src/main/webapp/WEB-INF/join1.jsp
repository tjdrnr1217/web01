<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<input type="text" value="${name}" />
	${name}
	${age}	
	${mem.userid}
	${mem.userpw}
	
	<hr />
	<%
		
		String name = (String) request.getAttribute("name");
		int age = (int)request.getAttribute("age");
		Member obj = (Member) request.getAttribute("mem");
		
		out.print( name );
		out.print( age );
		out.print( obj.getUserid() );
		out.print( obj.getUserpw() );
	%>
</body>
</html>
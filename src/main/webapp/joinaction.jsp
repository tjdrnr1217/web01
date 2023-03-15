<%@page import="dto.Member"%>
<%@page import="mapper.MemberMapper"%>
<%@page import="config.MyBatisContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>회원가입처리</title>
	</head>
	
	<body>
	<% 
		// 여기는 자바 문법이 가능함.
		// 여기는 기본적으로 몇가지 클레스의 객체를 생성해 놓았음.
		// HTTPServletRequest request; //요청
		// HTTPServletResponse response; //응답
		// System객체 생성 되어 있음.
		
		String id = request.getParameter("id"); // join에 있는 name값이 들어간다
		String pw = request.getParameter("pw"); 
		String pw2 = request.getParameter("pw2"); 
		String name = request.getParameter("name"); 
		String age = request.getParameter("age"); 
		String phone = request.getParameter("phone"); 
		String gender = request.getParameter("gender");
		
		//DB에 추가하고 적절한 페이지로 이동시켜야 함.
		MemberMapper mapper = MyBatisContext.getSqlSession().getMapper(MemberMapper.class);
		Member obj = new Member();
		obj.setUserid(id);
		obj.setUserpw(pw);
		obj.setUsername(name);
		obj.setUserage(Integer.parseInt(age));
		obj.setUserphone(phone);
		obj.setUsergender(gender);
		int ret = mapper.insertMemberOne(obj);
		
		if(ret == 1){
			response.sendRedirect("joinok.jsp"); // 404표시
		}else{
			response.sendRedirect("join.jsp"); // 회원가입으로 이동
		}
		
		
		out.print(id);
		out.print(pw);
		
	%>
	<%
	// 여기도 자바 문법이 가능함	
	%>
	</body>
</html>
<%@page import="dto.Member"%>
<%@page import="mapper.MemberMapper"%>
<%@page import="config.MyBatisContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>ȸ������ó��</title>
	</head>
	
	<body>
	<% 
		// ����� �ڹ� ������ ������.
		// ����� �⺻������ ��� Ŭ������ ��ü�� ������ ������.
		// HTTPServletRequest request; //��û
		// HTTPServletResponse response; //����
		// System��ü ���� �Ǿ� ����.
		
		String id = request.getParameter("id"); // join�� �ִ� name���� ����
		String pw = request.getParameter("pw"); 
		String pw2 = request.getParameter("pw2"); 
		String name = request.getParameter("name"); 
		String age = request.getParameter("age"); 
		String phone = request.getParameter("phone"); 
		String gender = request.getParameter("gender");
		
		//DB�� �߰��ϰ� ������ �������� �̵����Ѿ� ��.
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
			response.sendRedirect("joinok.jsp"); // 404ǥ��
		}else{
			response.sendRedirect("join.jsp"); // ȸ���������� �̵�
		}
		
		
		out.print(id);
		out.print(pw);
		
	%>
	<%
	// ���⵵ �ڹ� ������ ������	
	%>
	</body>
</html>
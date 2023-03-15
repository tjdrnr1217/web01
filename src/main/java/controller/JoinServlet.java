package controller;

import java.io.IOException;

import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// LoginServlet를 생성하고
// 서버주소가 127.0.0.1:8080/web01/login.do입력 => login2.jsp를 표시

// 1.상속
// 서버 재구동 127.0.0.1:8080/web01/join1.jsp입력
@WebServlet("/join1.do")
public class JoinServlet extends HttpServlet{

	// 2.오버라이드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. View로 필요한 정보를 전달
		req.setAttribute("name", "aaa");
		req.setAttribute("age", 13);
		
		Member obj = new Member();
		obj.setUserid("id01");
		obj.setUserpw("pw01");
		req.setAttribute("mem",obj);

		// 2. View를 화면에 표시
		req.getRequestDispatcher("/WEB-INF/join1.jsp").forward(req, resp);	
		
	// 주소는 join1.do 똑같은데 /WEB-INF/join2.jsp이름에 따라 결과가 바뀌네 나타난다
	// 1.JoinServlet.java -> 2.WEB-INF -> 3.join2.jsp
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}

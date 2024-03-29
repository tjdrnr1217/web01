package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1. 크롬에서                                                     입력하면
@WebServlet("/memberlist.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 임의의 회원목록 생성(ex 3명)
		List<Member> list= new ArrayList<Member>();
		for(int i=0;i<3;i++) {
			Member obj = new Member();
			obj.setUserid("id"+i);
			obj.setUsername("name"+i);
			list.add(obj);
		}
		// 2. jsp로 값 전달
		request.setAttribute("list", list);
		
		// 2. WEB-INF폴더의 memberlist1.jsp가 표시.
		request.getRequestDispatcher("/WEB-INF/memberlist1.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

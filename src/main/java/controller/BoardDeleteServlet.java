package controller;

import java.io.IOException;

import config.MyBatisContext;
import dto.Board;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.BoardMapper;

@WebServlet(urlPatterns = { "/board/deleteone.do" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public BoardDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardMapper bMapper = MyBatisContext.getSqlSession().getMapper(BoardMapper.class);
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		int ret = bMapper.deleteBoardOne(no);
		if(ret == 1) {
			response.sendRedirect("selectlist.do");
		}
	}

}

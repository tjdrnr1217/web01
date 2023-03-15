package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.BoardMapper;

import java.io.IOException;

import config.MyBatisContext;
import dto.Board;

@WebServlet(urlPatterns = { "/board/insertone.do" })
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardMapper bMapper = MyBatisContext.getSqlSession().getMapper(BoardMapper.class);

	public BoardInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// view로 정보를 전달
		request.setAttribute("title", "게시판글쓰기");

		// view를 표시.
		request.getRequestDispatcher("/WEB-INF/boardinsert1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자가 입력한 항목3개를 받아서 DB에 추가하고
		// 적절한 페이지로 이동시켜야함(절대로 post로 보내면 안됨, get으로만 보냄).
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		Board obj = new Board();
		obj.setTitle(title);
		obj.setContent(content);
		obj.setWriter(writer);

		int ret = bMapper.insertBoardOne(obj); // 4번
		if (ret == 1) { // 글쓰기 성공 => 게시판 목록 이동
			// 주소창을 selectlist.do로 변경시키고 엔터키를 누름 Get
			response.sendRedirect("selectlist.do");
		} else { // 글쓰기 실패 => 다시 글쓰기 화면으로 이동
					// 주소창을 insertone.do로 변경시키고 엔터키를 자동화 Get
			response.sendRedirect("insertone.do");

		}
	}

}

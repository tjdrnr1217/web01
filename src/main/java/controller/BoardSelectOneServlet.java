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

@WebServlet(urlPatterns = { "/board/selectone.do" })
public class BoardSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardSelectOneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		BoardMapper bMapper = MyBatisContext.getSqlSession().getMapper(BoardMapper.class);

		long no = Long.parseLong(request.getParameter("no"));
		
		// 1.mapper를 이용하여 게시글 1개 가져오기
		Board board = bMapper.selectBoardOne(no);
		
		// 2. View로 전송
		request.setAttribute("brd", board);
		
		// 3. view표시
		request.getRequestDispatcher("/WEB-INF/boardselectone1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

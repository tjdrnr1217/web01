package controller;

import java.io.IOException;
import java.util.List;

import config.MyBatisContext;
import dto.Board;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.BoardMapper;

@WebServlet(urlPatterns = { "/board/selectlist.do" })
public class BoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardMapper bMapper = MyBatisContext.getSqlSession().getMapper(BoardMapper.class);

		int page = 1;
		if (request.getParameter("page") != null) {
			// get에는 ?page=1일 경우 1의 값을 읽는 방법
			page = Integer.parseInt(request.getParameter("page"));
		}

		// 1일경우 start 1 end 20
		// 2일경우 start 11 end 20
		// 3일경우 start 21 end 30

		// 1. mapper를 통해서 결과값 가져오기
		List<Board> list = bMapper.selectBoardList(10 * page - 9, 10 * page);
		long total = bMapper.countBoardList();

		// 2. view로 값전달
		request.setAttribute("pages", (total - 1) / 10 + 1);
		request.setAttribute("list", list);

		// 3. view로 표시
		request.getRequestDispatcher("/WEB-INF/boardselectlist1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

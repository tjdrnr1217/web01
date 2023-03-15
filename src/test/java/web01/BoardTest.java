package web01;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import config.MyBatisContext;
import dto.Board;
import mapper.BoardMapper;

class BoardTest {
	BoardMapper bMapper = MyBatisContext.getSqlSession().getMapper(BoardMapper.class);

	@Test
	void insertBoardOne() {
		Board obj = new Board();
		obj.setTitle("제목");
		obj.setContent("내용임");
		obj.setWriter("작성자임");

		int ret = bMapper.insertBoardOne(obj);
		System.out.println(ret);
	}

}

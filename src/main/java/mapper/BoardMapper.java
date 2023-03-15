package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dto.Board;

@Mapper
public interface BoardMapper {
	@Insert({
		" INSERT INTO board(title, content, writer) ",
		" VALUES(#{obj.title},#{obj.content},#{obj.writer}) "
	})
	public int insertBoardOne(@Param("obj")Board obj);
	
	@Select({
		" SELECT b.* FROM( ",
		" SELECT b.*,ROW_NUMBER() OVER (ORDER BY no DESC) rown FROM board b ",
		" ) b WHERE rown >= #{start} AND rown <= #{end} ORDER BY no DESC "
	})
	public List<Board> selectBoardList(
			@Param("start") int start, @Param("end") int end);
	
	@Select({
		" SELECT COUNT(*) FROM board "
	})
	public long countBoardList();
	
	@Select({
		" Select b.* FROM board b WHERE NO=#{no}"	
	})
	public Board selectBoardOne(@Param("no") long no);
	
	@Delete({
		" DELETE FROM board WHERE NO=#{no} "
	})
	public int deleteBoardOne(@Param("no") int no);
	
	@Select({
		" SELECT MIN(no) FROM board WHERE No > #{no} "
	})
	public int selectNextBoardOne(@Param("no") long no);
}

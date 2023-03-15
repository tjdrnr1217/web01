package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dto.Board;
import dto.Member;

public interface MemberMapper {
	
	//회원가입
	@Insert({
		" INSERT INTO member(userid, userpw, username, userage, userphone, usergender, userdate) ",
		" VALUES(#{obj.userid}, #{obj.userpw}, #{obj.username}, #{obj.userage}, #{obj.userphone}, ",
		" #{obj.usergender}, CURRENT_DATE) "
	})
	public int insertMemberOne(@Param("obj") Member obj);
	
}


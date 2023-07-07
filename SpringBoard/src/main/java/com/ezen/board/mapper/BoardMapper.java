package com.ezen.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ezen.board.dto.BoardDTO;


public interface BoardMapper {
	@Select("SELECT * FROM  (SELECT rownum rn, a.* FROM "
			+ " (SELECT * FROM board2 ORDER BY board_id DESC) a)"
			+ " WHERE rn BETWEEN #{start} AND #{end}")
	List<BoardDTO> getPage(
			@Param("start") int start, 
			@Param("end") int end);
	
}

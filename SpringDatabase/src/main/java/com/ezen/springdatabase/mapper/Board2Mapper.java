package com.ezen.springdatabase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ezen.springdatabase.dto.Board2DTO;

public interface Board2Mapper {
	
	@Select("SELECT * FROM (SELECT rownum rn, a.* FROM "
			+ "(SELECT * FROM board2 ORDER BY board_id DESC) a)"
			+ " WHERE rn BETWEEN #{start} AND #{end}")
	List<Board2DTO> getPage(
			@Param("start") int rnStart, 
			@Param("end") int rnEnd);
	
//	@Insert("INSERT INTO board2(board_id, writer, board_pw, board_title, board_content, board_view, write_date)\r\n"
//			+ "    VALUES (board_id_seq.nextval, #{writer}, #{password}, #{title}, #{content}, #{view}, sysdate)")
//	int InsertBoard(
//			@Param("writer") String writer,
//			@Param("password") String board_pw,
//			@Param("title") String board_title,
//			@Param("content") String board_content,
//			@Param("view") int view);
//	
	
	@Insert("INSERT INTO board2(board_id, writer, board_pw, board_title, board_content, board_view, write_date)"
			+ "VALUES (board_id_seq.nextval, #{writer}, #{board_pw}, #{board_title}, #{board_content}, 0, sysdate)")
	int add(Board2DTO board2);
	
	@Delete("DELETE FROM board2 WHERE board_id = #{board_id}")
	int Delete(@Param("board_id") int board_id);
}

package com.ezen.board.mapper;

import org.apache.ibatis.annotations.Param;

import com.ezen.board.dto.BoardDTO;

public interface XMLBoardMapper {
	BoardDTO getBoard(int board_id);
	
	BoardDTO get(@Param("id") int id);
	
	int update(BoardDTO board);
}

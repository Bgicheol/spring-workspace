package com.ezen.board.mapper;

import java.util.List;

import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;

public interface XMLBoardMapper {
	BoardDTO getBoard(int board_id);
}

package com.ezen.springdatabase.mapper;

import java.util.List;

import com.ezen.springdatabase.dto.Board2DTO;

public interface XMLBoardMapper {
	
	List<Board2DTO> getAll();
	
	int add(Board2DTO board);
}

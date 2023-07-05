package com.ezen.springdatabase.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board2DTO {
	private Integer board_id;
	private String writer;
	private String board_pw;
	private String board_title;
	private String board_content;
	private Integer board_view;
	private Date wirte_date;
}

package com.ezen.springdatabase;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springdatabase.dto.Board2DTO;
import com.ezen.springdatabase.mapper.Board2Mapper;
import com.ezen.springdatabase.mapper.XMLBoardMapper;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {
	@Autowired
	XMLBoardMapper xmlBoardMapper;
	
	@Autowired
	Board2Mapper board2Mapper;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method =  RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		
		return "home";
	}
	
	
	@GetMapping("/board/list")
	public String list(int page, Model model) {
		
		if (page == 1) {
			model.addAttribute("board2", board2Mapper.getPage(1, 10));
		} else {
			model.addAttribute("board2", board2Mapper.getPage(21, 30));
		}
		
		return "/board/list";
	}
	
	@GetMapping("/board/all")
	public void all() {
		for (Board2DTO board : xmlBoardMapper.getAll()) {
			log.info(board);
		}
	}
	@GetMapping("/board/add")
	public void add() {
		Board2DTO board = new Board2DTO();
		
		board.setWriter("XML_Tester");
		board.setBoard_pw("xml");
		board.setBoard_content("대충내용");
		board.setBoard_title("XML Test");
		
		xmlBoardMapper.add(board);
		log.info("결과:" + xmlBoardMapper.add(board));
	}
}

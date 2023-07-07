package com.ezen.board;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.mapper.BoardMapper;
import com.ezen.board.mapper.XMLBoardMapper;
import com.ezen.board.sevice.BoardService;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	XMLBoardMapper xmlBoardMapper;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home");
		
		return "home";
	}
	
	@GetMapping("/list")
	public String list(int page, Model model) {
		int size = 10;
		int end = page * size;
		int start = end - 9;
		model.addAttribute("boards", boardMapper.getPage(start, end));
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String getBoard(int board_id, Model model) {
		BoardDTO board = xmlBoardMapper.getBoard(board_id);
	//	board.setBoard_id(board_id);	
		log.info(board);
		model.addAttribute("board", board);		
		return "detail";
	}
	
	@GetMapping("/modify")
	public void modify(int id, Model model) {
		log.info("getmodify");
		log.info("id: " + id);
		log.info(xmlBoardMapper.get(id));
		model.addAttribute("board", xmlBoardMapper.get(id));
	}
	
	@PostMapping("/modify")
	public String modifyProcess(BoardDTO board) {
		log.info("Postmodify");
		log.info(board);
		if (boardService.updateBoard(board)) {
			log.info(board);
			return "redirect:modify?id=" + board.getBoard_id();			
		} else {
			return "redirect:list?page=1";
		}
		// 전달받은 비밀번호와 DB에서 꺼낸 비밀번호를 비교하고
	}
}

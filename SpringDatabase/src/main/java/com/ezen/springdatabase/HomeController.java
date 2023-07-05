package com.ezen.springdatabase;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springdatabase.mapper.Board2Mapper;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {
	
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
	
	
	@GetMapping("/borad/list")
	public String list(int page, Model model) {
			log.info(page);
			if (page == 1) {
		} else {
			model.addAttribute("board", board2Mapper.getPage(11, 20));
		}
		
		return "/board/list";
	}
	
}

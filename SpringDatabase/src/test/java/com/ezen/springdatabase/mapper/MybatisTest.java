package com.ezen.springdatabase.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.springdatabase.dto.Board2DTO;
import com.ezen.springdatabase.dto.EmployeeDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	Board2Mapper board2Mapper;
	
	
	@Ignore
	@Test
	public void text() {
		for (EmployeeDTO emp : employeeMapper.getAll()) {
			log.info(emp);
		};
		
	}
	
	@Ignore
	@Test
	public void test2() {
		for (EmployeeDTO emp : employeeMapper.getAll2()) {
			log.info(emp);
		}
	}
	@Ignore
	@Test
	public void test3() {
		for (Board2DTO board2 : board2Mapper.getPage(1, 5)) {
			log.info(board2);
		};
		
	}
	
	@Test
	public void test4() {
		Board2DTO board = new Board2DTO();
		
		board.setBoard_pw("1234");
		board.setWriter("글쓴이");
		board.setBoard_title("제목");
		board.setBoard_content("내용");
		
		//assertEquals(1, board2Mapper.add(board));		
		assertTrue(board2Mapper.add(board) > 0);
	}
	
	@Test
	public void test5() {
		assertEquals(1, board2Mapper.Delete(16));
	}
}

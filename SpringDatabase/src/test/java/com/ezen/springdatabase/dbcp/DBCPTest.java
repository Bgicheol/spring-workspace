package com.ezen.springdatabase.dbcp;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBCPTest {
	
	
	@Autowired
	HikariDataSource datasource;
	
	@Test
	public void contextTest() {
		log.info(datasource);
		assertNotNull(datasource);
	}
	@Ignore
	@Test
	public void dsTest() {
		HikariDataSource ds = DBConnection.getDataSource();
		assertNotNull(ds);
		
		String sql = "SELECT * FROM employees";
		// HikariDataSource로부터 꺼낸 Connection은 close를 해도 끊기지 않고 반환된다
		
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()){
				System.out.printf("%s,%d\n",
						rs.getString("first_name"),
						rs.getInt("salary"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

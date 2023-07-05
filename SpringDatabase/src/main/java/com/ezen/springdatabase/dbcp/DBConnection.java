package com.ezen.springdatabase.dbcp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {
	
	public static HikariDataSource getDataSource() {
	HikariConfig config = new HikariConfig();
	config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
	config.setUsername("hr");
	config.setPassword("1234");
	config.addDataSourceProperty("cachePrepStmts", "true");
	config.addDataSourceProperty("prepStmtCacheSize", "250");
	config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
	config.setMinimumIdle(3);// 최소 3개의 연결은 유지한다
	config.setMaximumPoolSize(10); // 최대 연결 개수는 10개다
						// 1초   60초  10분
	config.setIdleTimeout(1000 * 60 * 10); // 10분간 연결이 없으면 알아서 끊김

	// 설정을 전달해 DB 커넥션 풀 객체를 생성
	return new HikariDataSource(config);
	}
}

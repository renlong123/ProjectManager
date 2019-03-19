package com.byd.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	
	static Logger logger = Logger.getLogger(DBUtils.class.getName());
	
	static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

	public static Connection getConnection() {
		Connection c = null;
		try {
			c = dataSource.getConnection();
		} catch (SQLException e) {
			logger.error("数据库连接出错",e);
			e.printStackTrace();
		}
		return c;
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("关闭出错",e);
				e.printStackTrace();
			}
		}
	}
	
}

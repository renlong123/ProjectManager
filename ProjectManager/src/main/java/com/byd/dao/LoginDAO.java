package com.byd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public String selectOne(Connection conn,String name) throws SQLException {
		String sql = "select * from user_ where user_name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String password = rs.getString("user_password");
			return password;
		}else {
			return null;
		}
	}

}

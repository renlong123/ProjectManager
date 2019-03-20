package com.byd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckDAO {
	
	public boolean selectOne(Connection conn,int jobNum) throws SQLException {
		String sql = "select * from user_ where user_jobNumber = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, jobNum);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}

}

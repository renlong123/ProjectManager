package com.byd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.byd.bean.User;

public class RegisterDAO {
	
	public boolean registerDAO(Connection conn,User user) throws SQLException {
		
		String sql = "insert into user_ values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, user.getJobNumber());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPhoneNumber());
		ps.setString(4, user.getEmail());
		ps.setBoolean(5, user.isSex());
		ps.setString(6, user.getPost());
		ps.setDate(7, new java.sql.Date(user.getEntryDate().getTime()));
		ps.setString(8, user.getPassword());
		int result = ps.executeUpdate();
		
		if(result==1)
			return true;
		return false;
	}

}

package com.byd.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.byd.bean.User;
import com.byd.dao.RegisterDAO;
import com.byd.utils.DBUtils;

public class RegisterService {
	
	RegisterDAO dao = new RegisterDAO();
	public boolean registerService(User user) {
		
		Connection conn = DBUtils.getConnection();
		boolean isSuccess = false;
		try {
			isSuccess = dao.registerDAO(conn, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}

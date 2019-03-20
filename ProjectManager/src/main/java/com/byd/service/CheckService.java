package com.byd.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.byd.dao.CheckDAO;
import com.byd.utils.DBUtils;

public class CheckService {
	
	CheckDAO dao = new CheckDAO();
	
	public boolean isExists(int jobNum) {
		Connection conn = DBUtils.getConnection();
		boolean b = false;
		try {
			b = dao.selectOne(conn, jobNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}

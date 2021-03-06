package com.byd.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.byd.bean.Product;
import com.byd.dao.LoginDAO;
import com.byd.utils.DBUtils;

public class LoginService {
	
	private LoginDAO dao = new LoginDAO();
	public boolean isRegistered(String username,String password) {
		
		Connection conn = DBUtils.getConnection();
		
		
		try {
			String selectName = dao.selectOne(conn, username);
			if(selectName!=null&&selectName.equalsIgnoreCase(password)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public List<Product> list(){
		Connection conn = DBUtils.getConnection();
		List<Product> list = null;
		 try {
			list = dao.selectAll(conn);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}

}

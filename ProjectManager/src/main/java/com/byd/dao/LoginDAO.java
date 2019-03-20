package com.byd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.byd.bean.Product;

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
	
	public List<Product> selectAll(Connection conn) throws NumberFormatException, SQLException {
		String sql = "select * from product_";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Product> lists = new ArrayList<Product>();
		
		while(rs.next()) {
			Product p = new Product();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setName(rs.getString("name"));
			p.setPrice(Float.parseFloat(rs.getString("price")));
			lists.add(p);
		}
		
		return lists;
		
	}

}

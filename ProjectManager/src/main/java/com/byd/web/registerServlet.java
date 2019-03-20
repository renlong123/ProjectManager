package com.byd.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.byd.bean.User;
import com.byd.service.RegisterService;

import com.mchange.v2.codegen.bean.BeangenUtils;

/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    RegisterService register = new RegisterService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String[]> params = request.getParameterMap();
		User user = new User();
				
		user.setJobNumber(Integer.parseInt(request.getParameter("jobNumber")));
		user.setName(request.getParameter("name"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setEmail(request.getParameter("email"));
		user.setSex(request.getParameter("sex").equals("1")?true:false);
		user.setPost(request.getParameter("post"));
		try {
			user.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("entryDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPassword(request.getParameter("password"));
		
		if(register.registerService(user)) {
			System.out.println("×¢²á³É¹¦£¬¿ÉÒÔµÇÂ½ÁË");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			System.out.println("×¢²áÊ§°Ü");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

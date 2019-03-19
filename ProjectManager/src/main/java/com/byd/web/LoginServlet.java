package com.byd.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.byd.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    LoginService loginService = new LoginService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if(!loginService.isRegistered(username, password)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			String s = request.getParameter("name")+request.getParameter("password");
			Cookie c = new Cookie("username",URLEncoder.encode(request.getParameter("name"),"UTF-8"));//cookie不能存中文，进行编码
			Cookie passwordc = new Cookie("password",URLEncoder.encode(request.getParameter("password"),"UTF-8"));
			c.setMaxAge(24*60*60);
			passwordc.setMaxAge(24*60*60);
			c.setPath(request.getContextPath());//设置cookie携带路径
			passwordc.setPath(request.getContextPath());
			response.addCookie(c);
			response.addCookie(passwordc);
			HttpSession session = request.getSession();
			session.setAttribute("a", 100);
			response.getWriter().write("登陆成功，你的用户名和密码是"+s);
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

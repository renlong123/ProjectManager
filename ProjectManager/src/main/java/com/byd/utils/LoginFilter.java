package com.byd.utils;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 *该过滤器用于对全局进行登陆验证，如果没有登陆，就跳转到login.jsp,否则直接访问
 */
public class LoginFilter implements Filter {

	private String excludedPaths;
	private String[] excludedPathArray;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
       System.out.println("登陆过滤构造");
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		excludedPaths = fConfig.getInitParameter("excludedPaths");
		if(excludedPaths!=null) {
			excludedPathArray = excludedPaths.split(",");
		}
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String username = null;
		String password = null;
		
		Cookie[] cookies = req.getCookies();
		//HttpSession session = req.getSession();
		
		if(cookies == null) {
			if(isFilterExcluded(req)/*req.getRequestURI().equals(req.getContextPath()+"/login.jsp")*/) {
				System.out.println("bdkscd");
				chain.doFilter(req, res);
			}else {
				System.out.println("没有登陆，请登陆");
				res.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}else {
			for(Cookie c:cookies) {
				if(username==null&&c.getName().equals("username")) {
					username = c.getValue();
					username = URLDecoder.decode(username, "UTF-8");
				}
				if(password==null&&c.getName().equals("password")) {
					password = c.getValue();
				}
			}
			if(username!=null&&password!=null) {
				chain.doFilter(request, response);
			}else {
				if(isFilterExcluded(req)/*req.getRequestURI().equals(req.getContextPath()+"/login.jsp")*/) {
					System.out.println("bdkscd");
					chain.doFilter(req, res);
				}else {
					System.out.println("没有登陆，请登陆");
					res.sendRedirect(req.getContextPath()+"/login.jsp");
				}
			}
		}
	}

	private boolean isFilterExcluded(HttpServletRequest request) {
		if(excludedPaths==null||excludedPathArray==null) {
			return false;
		}
		String urn = request.getRequestURI().replace(request.getContextPath(), "").trim();
		for(String s:excludedPathArray) {
			if(urn.startsWith(s)||urn.endsWith(s)) {
				return true;
			}
		}
		return false;
	}

}

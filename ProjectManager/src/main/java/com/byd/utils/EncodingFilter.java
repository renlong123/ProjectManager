package com.byd.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 * 该过滤器用于对全局编码进行处理
 */
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        System.out.println("字符编码过滤器构造");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("字符编码过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletRequest myreq = new MyRequest(req);
		
		chain.doFilter(myreq, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

class MyRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	private boolean hasEncode;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public Map getParameterMap() {
		String method = request.getMethod();
		if(method.equalsIgnoreCase("post")) {
			try {
				request.setCharacterEncoding("UTF-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equalsIgnoreCase("get")) {
			Map<String,String[]> params = request.getParameterMap();
			if(!hasEncode) {
				for(String name : params.keySet()) {
					String[] values = params.get(name);
					if(values!=null) {
						for(int i=0;i<values.length;i++) {
							try {
								values[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode = true;
			}
			return params;
		}
		return super.getParameterMap();
	}
		
	@Override
	public String getParameter(String name) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		return values[0]; // 取回参数的第一个值
	}

	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}
}

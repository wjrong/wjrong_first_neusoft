package com.wjrong.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 判断如果没有登陆不能进入后台界面
 * @author wjrong
 * @data 2013-10-23
 *
 */
public class AdminFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getSession().getAttribute("userlogin") == null){
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}else{
			filter.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig fin) throws ServletException { 
	}

}

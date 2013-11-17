package com.wjrong.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import com.wjrong.model.SystemContext;

public class SystemContextFilter implements Filter  {
	private int pageSize=0; //每页显示数
	
	@Override
	public void destroy() { }

	/** 
     * 获得pageOffset参数的值 
     * @param request 
     * @return 
     */ 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		try {
	
			int pageOffset = 0;	//现在的位置
			int categoryid =1;//分类ID
			
			try {
				String ps =request.getParameter("pageSize");
				if (ps != null) {  
					pageSize =Integer.parseInt(ps);  
	            }  
			
			} catch (NumberFormatException e) {}
			
			try {
				String pageOff = request.getParameter("pageOffset");
				if(pageOff==null || pageOff.length() <= 0){
					pageOff=request.getParameter("pager.offset");

				}
				//判断pageOff是否整数， true-整数  false-非整数
				if (NumberUtils.isDigits(pageOff)) {
					
					pageOffset =Integer.parseInt(pageOff);  
	            }
				
				String category = request.getParameter("categoryid");
				if(category==null || category.length() <= 0){
					//判断category是否整数， true-整数  false-非整数
					if (NumberUtils.isDigits(category)) {
						
						categoryid =Integer.parseInt(category);  
		            }

				}
				
				
			} catch (NumberFormatException e) {}
			
				SystemContext.setOffSet(pageOffset);
				SystemContext.setPageSize(pageSize);
				SystemContext.setcategoryid(categoryid);
				filter.doFilter(request, response);
			}
		//使用完Threadlocal，将其删除。使用finally确保一定将其删除  
		finally{
			
			SystemContext.removeOffSet();
			SystemContext.removePageSize();
			pageSize=10;
			SystemContext.removecategoryid();
			
		}
	}

 
	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {  
				pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));  
			} catch (NumberFormatException e) {  
				pageSize = 10;  
			}
	}

}

package com.slj.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import com.slj.model.Admin;
import com.slj.model.User;

public class adminLoginFilter implements Filter{
	private FilterConfig filterConfig = null;

	public void destroy() {
		System.out.println(" adminloginFilter destroy");
		this.filterConfig=null;
	}

	public void doFilter(ServletRequest request1, ServletResponse response1,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;
		String adminflag = (String)request.getSession().getAttribute("adminflag");
	if(adminflag != null && adminflag.equals("success"))
	{
			Admin admin = (Admin)request.getSession().getAttribute("admin");
			if(admin != null)
			{
				System.out.println("**************************************************************");
				System.out.println(admin.getName()+"鐧诲綍鐘舵�鐘舵�姝ｇ‘");
				System.out.println("**************************************************************");
				filterChain.doFilter(request, response);
				return;
				
			}
			
			System.out.println("**************************************************************");
			System.out.println("鐧诲綍鐘舵�閿欒");
			System.out.println("涓绘満"+request.getLocalAddr()+"鍙楀埌鎭舵剰鐧诲綍from"+request.getRemoteHost()+"灏濊瘯鐧诲綍鍒"+ request.getRequestURI());
			System.out.println("**************************************************************");
			response.sendRedirect("adminlogin.jsp");
			return;
			
		}
		
		System.out.println("**************************************************************");
		System.out.println("鐧诲綍鐘舵�閿欒");
		System.out.println("涓绘満"+request.getLocalAddr()+"阿斯顿快乐到家from"+request.getRemoteHost()+"灏濊瘯鐧诲綍鍒"+ request.getRequestURI());
		System.out.println(new Date());
		System.out.println("**************************************************************");
		response.sendRedirect("adminlogin.jsp");
		return;
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(" adminloginFilter init");
		
		this.filterConfig = arg0;
	}
	
	

}

package com.slj.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	protected FilterConfig filterConfig = null;
	protected String encoding="";
	public void destroy() {
		filterConfig = null;
	encoding = null;
	System.out.println(this.encoding+"using my filter");

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
			servletRequest.setCharacterEncoding(encoding);
		servletResponse.setCharacterEncoding(encoding);
		filterChain.doFilter(servletRequest, servletResponse);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.filterConfig = filterConfig;
		this.encoding=filterConfig.getInitParameter("encoding");
		System.out.println(this.encoding);
	}

}

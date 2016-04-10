<%@ page language="java" import="java.util.*,com.slj.dto.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 
session.setAttribute("login","true");
response.sendRedirect("loginSuccess.jsp");
%>


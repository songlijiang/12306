<%@ page language="java" import="java.util.*,com.slj.model.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%--<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Admin admin = (Admin)session.getAttribute("admin");

if(admin == null)
{
	response.sendRedirect("adminlogin.jsp");
	return;
}
System.out.println("admin="+admin.getName());
String adminflag = (String)session.getAttribute("adminflag");

if(adminflag == null || !adminflag.equals("success"))
{
	response.sendRedirect("adminlogin.jsp");
	System.out.println("adminflag="+adminflag);
	return;
}
session.setAttribute("login","true");      //赋予一般用户的权限,但是不能够买票只能查看
%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'adminloginsuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    adminloginsuccess.jsp
    <a href="addTicket.jsp">添加车票</a>
    <a href="upadteTicket.jsp">修改车票</a>
    <a href= "listTicketByadminOfdelete.action?pageNow=1">删除车票</a>
    <a href="listTicketByadmin.action?pageNow=1">查看车票</a>
  </body>
</html>

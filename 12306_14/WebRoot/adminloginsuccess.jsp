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
session.setAttribute("login","true");      //����һ���û���Ȩ��,���ǲ��ܹ���Ʊֻ�ܲ鿴

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
    <a href="adminTicketHandle.jsp">��Ʊ����</a>
    <a href="adminUserHandle.jsp">�û�����</a>
    
  </body>
</html>

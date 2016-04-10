<%@ page language="java" import="java.util.*" pageEncoding="GB18030" errorPage="error/errorHandle.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userHandle.jsp' starting page</title>
    
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
  <ul type="circle">
  	<li> <a href="listUser">查看所有用户</a>  </li>
  	<li>
	  	<big>通过id加载用户</big>
	   <s:form action="loadUser" method="post" namespace="/">
	   	<s:textfield label="id" name="id"></s:textfield>
	   	<s:submit label="查询"></s:submit>
	   </s:form>
   </li>
  </ul>
  
   
   
  </body>
</html>

<%@ page language="java" import="java.util.*" errorPage="errorHandle.jsp" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listUser.jsp' starting page</title>
    
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
 <table align="center" border="1" bgcolor="blue">
   <thead>
   	<tr>
   	<th>id</th>
   	<th>name </th>
   	<th>password</th>
   	</tr>
   </thead>
   <tbody>
   
   <s:iterator value="users">
  		<tr>
  			<td>	<s:property value="id"/> </td>
  			<td>	<s:property value="name"/> </td>
  			<td>  <s:property value="password"/> </td>
  		</tr>
  	</s:iterator>
  	</tbody>
   
   
   </table>
   <s:debug></s:debug>
  </body>
</html>

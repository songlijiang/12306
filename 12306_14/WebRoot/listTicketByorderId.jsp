<%@ page language="java" import="java.util.*,com.slj.model.*" pageEncoding="gbk"%>
<%@include file="user_statue_check.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
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
    
     <table align="center" border="1">
    	<thead>
    		<tr>
    		<th>车名</th>
    		<th>起始站</th>
    		<th>终点</th>
    		<th>发车时间</th>
    		<th>到站时间</th>
    		<th>途径站点</th>
    		<th>数量</th>
    		<th>退票</th>
    		</tr>
    	</thead>
    	<tbody>
    	
    		<s:iterator value="tickets" var="ticket" >
    		<tr>
    		<td>
    	<s:property value="name" />
    
  			 </td>
  			 <td>
    	<s:property value="startstation"/>
    
  			 </td>
  			 <td>
    	<s:property value="endstation"/>
    
  			 </td>
  			 <td>
    	<s:property value="starttime"/>
    
  			 </td>
  			  <td>
    	<s:property value="endtime"/>
    
  			 </td>
  			  <td>
    	<s:property value="stations"/>
  			 </td>
  			 <td>
    	<s:property value="num"/>
  			 </td>
  			 
  			  <td>
  			 
    	<a href="deleteTicketById.jsp?did=${ticket.id}"> 退票</a>
    
  			 </td>
    		</tr>
    		 </s:iterator>
    			<tr>
    		<td></td>
    		</tr>
    	
    	
    	
    	</tbody>
    
    </table>
    <a href="loginSuccess.jsp">返回导航页</a>
    
  </body>
</html>

<%@ page language="java" import="java.util.*,com.slj.model.*" pageEncoding="gbk"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="a" %>

<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
	
  </head>
 
  <body>
  
    
    <a href="adminloginsuccess.jsp">返回admin界面</a>
    <table align="center" border="1">
    	<thead>
    		<tr>
    		<th>车名</th>
    		<th>起始站</th>
    		<th>终点</th>
    		<th>发车时间</th>
    		<th>到站时间</th>
    		<th>剩余车票</th>
    		 <th>途径站点</th>
    		
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
    	<s:property value="num"/>
    
  			 </td>
  			  <td>
    	<s:property value="stations"/>
  			 </td>
  			 
    		</tr>
    		 </s:iterator>
    			<tr>
    		<td></td>
    		</tr>
    	
    	
    	
    	</tbody>
    
    </table>
    <%--
     <a href= "listTicketByadmin.action?pageNow=${sessionScope.pageNow}">下一页</a>
     --%>
     <a:forEach begin="1" end="${pageAll}" step="1" var="i">
  	<a href= "listTicketByadmin.action?pageNow=${i}">   第${i}页       </a>
  </a:forEach>
  </body>
</html>

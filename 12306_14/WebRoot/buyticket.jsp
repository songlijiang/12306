<%@ page language="java" import="java.util.*,com.slj.model.*" pageEncoding="gbk"%>
<%@include file="user_statue_check.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="a" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
   
    <table align="center" border="1">
    	<thead>
    		<tr>
    		<th>����</th>
    		<th>��ʼվ</th>
    		<th>�յ�</th>
    		<th>����ʱ��</th>
    		<th>��վʱ��</th>
    		<th>;��վ��</th>
    		<th>ʣ�೵Ʊ</th>
    		<th>��Ʊ</th>
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
  			 
  			 
    	<div id="visible"><a href="buyTicketById.jsp?id=${ticket.id}"> ��Ʊ</a></div>
    
  			 </td>
    		</tr>
    		 </s:iterator>
    			<tr>
    		<td></td>
    		</tr>
    	
    	
    	
    	</tbody>
    
    </table>
  <a:forEach begin="1" end="${pageAll}" step="1" var="i">
  	<a href= "listTicket.action?pageNow=${i}">   ��${i}ҳ       </a>
  </a:forEach>
   
   
   
  
 
    
  </body>
</html>

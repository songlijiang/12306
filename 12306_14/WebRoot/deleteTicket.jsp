<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
    
    <title>My JSP 'deleteTicket.jsp' starting page</title>
    
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
  
    <table align="center" border="1">
    	
    	<thead>
    		<tr>   <div align="center">   ɾ����Ʊ    </div></tr>
    		<tr>
    		<th>����</th>
    		<th>��ʼվ</th>
    		<th>�յ�</th>
    		<th>����ʱ��</th>
    		<th>��վʱ��</th>
    		<th>ʣ�೵Ʊ</th>
    		<th>ɾƱ</th>
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
  			 
  			 
    	<div id="visible"><a href="deleteTicketByAdmin.jsp?did=${ticket.id}"> ɾƱ</a></div>
    
  			 </td>
    		</tr>
    		 </s:iterator>
    			<tr>
    		<td></td>
    		</tr>
    	
    	
    	
    	</tbody>
    
    </table>
     <a:forEach begin="1" end="${pageAll}" step="1" var="i">
  	<a href= "listTicketByadminOfdelete.action?pageNow=${i}">  ��${i}ҳ       </a>
  </a:forEach>
  </body>
</html>

<%@ page language="java" import="java.util.*,com.slj.model.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="user_statue_check.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>�û�����</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		ul ,li{
			list-style: none;
		}
		
		ul {
			padding: 0px;	
			margin: 0px;	
		}
		.main{
			
			background-image: url("./images/main.jpg");	
			background-repeat: repeat-x;
			width: 150px;
		}
		.main{
			font-size:20px;
			float: left;
			position: relative;
			left: 30%;				
			
		}
		
	
	</style>

  </head>
  
  <body>
  <h1 align="center"> ��ӭ<font color="blue"><%= ((User)session.getAttribute("user")).getName() %></font>��½</h1>
  
  <div align="center" style="color:red">
  <ul>
  	<li class="main"> <a href="listTicket.action?pageNow=1">��ͨ��Ʊ</a></li>
  	<li class="main"><a href="searchTicket.jsp">������Ʊ</a></li>
  	<li class="main"><a href="listTicketById.action">�鿴�ҵĹ��ﳵ</a></li>
  </ul>
  </div>
  
  
  
  </body>
</html>

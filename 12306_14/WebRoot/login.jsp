<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String msg = (String)session.getAttribute("msg");
String loginfail = (String)session.getAttribute("loginfail");
if(msg != null)
out.print(msg);
if(loginfail != null)
	out.print(loginfail);
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
	  <script type="text/javascript" src="js/jQuery.js"></script>
   <script type="text/javascript" src="js/verifyCode.js"></script>
   <STYLE type="text/css">
   		#inputs{
   			font: lighter 20px ;
   			
   		}
   		
   		
   
   
   </STYLE>
  </head>
  
  <body>
  
  <form action="login" id="form">
  <div id="inputs">
  	name<input type="text" name="name" id="input"/><br>
  		password<input type="password" name="password" id="input"/><br>
  		验证码 <input id="veryCode" name="veryCode" type="text" class="yzm" value="please input verycode" onmouseout="isRightCode('show')"/> <br>
  		
    <img id="imgObj" alt="" src="DrawImage.a" />
    <a href="login.jsp" onclick="changeImg()">换一张</a>
   <div style="line-height: 38px; color: #FF0000; text-align: center;"  id="info">&nbsp;</div>
  <input type="button" class="submit" id="input" size="30" onclick="isRightCode('submit')" value="登陆">
  </div>
  </form>
  
  
   
   
    
 
   
   
   
 
  
   
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%


String login = (String)session.getAttribute("login");

if(login == null ||!login.equals("true"))
{
	session.setAttribute("msg","请登录");
	response.sendRedirect("./login.jsp");
	System.out.println("**************************************************************");
	System.out.println("主机"+request.getLocalAddr()+"受到恶意登录from"+request.getRemoteHost());
	System.out.println("**************************************************************");
	out.println("恶意登录from"+request.getRemoteAddr());
	
	return;
	
	
}
	
%>


<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%


String login = (String)session.getAttribute("login");

if(login == null ||!login.equals("true"))
{
	session.setAttribute("msg","���¼");
	response.sendRedirect("./login.jsp");
	System.out.println("**************************************************************");
	System.out.println("����"+request.getLocalAddr()+"�ܵ������¼from"+request.getRemoteHost());
	System.out.println("**************************************************************");
	out.println("�����¼from"+request.getRemoteAddr());
	
	return;
	
	
}
	
%>


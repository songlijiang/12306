<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addTicket.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link href="bootstrap/bootstrap.css" rel="stylesheet" media="screen">
    <link href="bootstrap/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
  </head>
  
  <body>
  <div class="container">
  
   <form action="addTicket" method="post">
   		 <fieldset>
   		
   		 
          
            
          "tname"   <input type="text" name="tname"   /><br/>
            "startstation"<input type="text" name="startstation" style="width:100px"/><br/>
             "endstation" <input type="text" name="endstation"/><br/>
            
            
            
            <div class="form-group">
                <label for="dtp_input1" class="col-md-2 control-label">starttime</label>
                <div class="input-group date form_datetime col-md-5" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="starttime">
                    <input class="form-control" size="16" readonly="readonly" type="text" name="starttime">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input id="dtp_input1" value="" type="hidden"><br>
            </div>
            
             <div class="form-group">
                <label for="dtp_input1" class="col-md-2 control-label">endtime</label>
                <div class="input-group date form_datetime col-md-5" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="endtime">
                    <input class="form-control" size="16" readonly="readonly" type="text" name="endtime">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input id="dtp_input1" value="" type="hidden"><br>
            </div>
            
		
        </fieldset>
           num<input type="text" name="num"/><br/>
            stations  <input type="text" name="stations"/><br/>
			<input type="submit" value="Ìí¼Ó"> 
  </form>
 
 </div> 
 
 <script type="text/javascript" src="bootstrap/jquery-1.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap-datetimepicker_002.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	$('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	$('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
</script>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>

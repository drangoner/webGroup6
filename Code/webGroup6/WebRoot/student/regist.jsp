<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'regist.jsp' starting page</title>
    
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
    <% 
    	request.setCharacterEncoding("utf8");
     %>
     
      <%
      	//String err = (String)request.getAttribute("fail");
      	String user = (String)request.getAttribute("user");
      	String sid = (String)request.getAttribute("sid");
      	String passwd = (String) request.getAttribute("passwd");
      	//Map<String,String> map = (Map<String,String>) request.getAttribute("StuInfo");
      	
      	Object regist = request.getAttribute("regist");
      	if(regist!=null){
      		session.setAttribute("user", user);
      		session.setAttribute("sid", sid);
      		session.setAttribute("passwd", passwd);
      		response.sendRedirect("../student/regist_detail.jsp");

      	}else{
      		response.sendRedirect("../student/regist.html");
      		//if(err!=null){
      		//response.sendRedirect("../student/sign-in.html");
 			//}
 			//response.sendRedirect("../student/sign-in.html");
 		}
        %>
  </body>
</html>

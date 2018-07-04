<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
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
      	String err = (String)request.getAttribute("fail");
      	String user = (String)request.getAttribute("user");
      	String passwd = (String) request.getAttribute("passwd");
      	Map<String,String> map = (Map<String,String>) request.getAttribute("StuInfo");
      	
      	Object login = request.getAttribute("login");
      	if(login!=null){
      		session.setAttribute("user", user);
      		session.setAttribute("passwd",passwd);
      		session.setAttribute("name",map.get("name"));
      		session.setAttribute("lastlogin",map.get("lastlogin"));
      		
      		session.setAttribute("sid", map.get("sid"));
      		String sex = map.get("sex").equals("0") ? "男" : "女";
      		session.setAttribute("sex", sex);
      		session.setAttribute("major", map.get("major"));
      		session.setAttribute("class", map.get("class"));
      		session.setAttribute("intime", map.get("intime"));
      		session.setAttribute("outtime", map.get("outtime"));
      		session.setAttribute("city", map.get("city"));
      		session.setAttribute("phone", map.get("phone"));
      		session.setAttribute("email", map.get("email"));
      		session.setAttribute("company",map.get("company"));
      		response.sendRedirect("../student/index.jsp");

      	}else{
      		response.sendRedirect("../student/sign-in.html");
      		//if(err!=null){
      		//response.sendRedirect("../student/sign-in.html");
 			//}
 			//response.sendRedirect("../student/sign-in.html");
 		}
        %>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>网上通讯录后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" type="text/css" href="./admin/css/login.css"/> 
  </head>
  
  <body>
  
  <div id="login">  
        <h1>Login</h1>  
        <form action="admin/LoginServlet" method="post">  
            <input type="text" required="required" placeholder="用户名" name="user"></input>  
            <input type="password" required="required" placeholder="密码" name="passwd"></input>  
            <button class="but" type="submit">登录</button> 
             <span id="err" style="color:#f55;"></span>
        </form>  
    </div>  
    
    <% 
    	request.setCharacterEncoding("utf8");
     %>
     
      <%
      	String err = (String)request.getAttribute("fail");
      	String user = (String)request.getAttribute("user");
      	Map<String,String> adminInfo = (Map<String,String>) request.getAttribute("adminInfo");
      	
      	Object login = request.getAttribute("login");
      	if(login!=null){
      	
      		session.setAttribute("name",adminInfo.get("name"));
      		session.setAttribute("lastlogin",adminInfo.get("lastlogin"));
      		session.setAttribute("user", user);
      		session.setAttribute("usernum", adminInfo.get("usernum"));
      		response.sendRedirect("html/main.jsp");

      	}else{
      		if(err!=null){
       %>
       <script>
       document.getElementById("err").innerHTML ="<%=err%>";
       </script>
       <%
        	} 
        }
       %>

    
  </body>
</html>

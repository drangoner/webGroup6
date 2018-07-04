<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>

<%
//session

if(session.getAttribute("user")==null){
	response.sendRedirect("./sign-in.html");
}


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <meta charset="utf-8">
    <title>班级通讯录</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
  
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i><%=session.getAttribute("name") %>
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="myinformation.jsp">我的信息</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">设置</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="signout.jsp">注销</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.jsp"><span class="first">网上</span> <span class="second">通讯录</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>个人管理<span class="label label-info">2</span></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
           
            <li ><a href="update.jsp">修改信息</a></li>
         
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>通讯录查询<span class="label label-info">2</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="./majorlist.jsp">专业通讯录查询</a></li>
            <li ><a href="./classlist.jsp">班级通讯录查询</a></li>
        </ul>



    </div>
    

    
    <div class="content">

        <div class="header">
            <div class="stats">

            </div>

            <h1 class="page-title">欢迎使用网上通讯录</h1>
        </div>
        
            <ul class="breadcrumb">
            </ul>
    <div class="well" id="list">
    <table class="table">
      <thead>
        <tr>
          <th></th>
          <th>姓名</th>
          <th>学号</th>
          <th>班级</th>
          <th>电话</th>
          <th>邮箱</th>
        </tr>
      </thead>
      <tbody>
       
      </tbody>
    </table>
</div>
    </div>

   <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    	var xmlhttp;
      if (window.XMLHttpRequest)
      {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
      }
      else
      {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlhttp.onreadystatechange=function()
      {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
          data=xmlhttp.responseText;
          if(data != null){
            //console.log(data);
            //showDetail(data);
            change(data);
          }else{
            console.log("error");
          }
          
        }
      }
      
      <%
        String c= (String)session.getAttribute("class");
        c ="\""+c+"\"";
      %>
      xmlhttp.open("GET","../servlet/GetStudentsByClass?class="+<%=c%>,true);
      xmlhttp.send();
      
      function change(da){
        var json = JSON.parse(da);
        var data = json.student;
        console.log(data);
        var html = "<table class=\"table\"><thead><tr><th></th><th>姓名</th><th>学号</th><th>班级</th><th>电话</th><th>邮箱</th></tr></thead>"+
        "<tbody>";
        for (var i=0;i<data.length;i++){
          var item = data[i];
          html+="<tr><td>"+(i+1)+"</td><td>"+item.name+"</td><td>"+item.id+"</td><td>"+item.class+"</td><td>"+
          item.phone+"</td><td>"+item.email+"</td></tr>";
        }
        html+="</tbody></table>";
        document.getElementById("list").innerHTML=html;
      }
    
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>

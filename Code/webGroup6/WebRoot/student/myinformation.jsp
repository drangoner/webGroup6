<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><%=session.getAttribute("name") %>的详细信息</title>
    
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

        </ul>
        <a class="brand" ><span class="first">我的</span> <span class="second">信息</span></a>
    </div>
</div>






<div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading"></p>
            <div class="block-body">
                <form>
                    <label>姓名</label>
                    <input type="text" class="span12" id="name" value="<%=session.getAttribute("name") %>" />
                    <label>性别</label>
                    <input type="text" class="span12" id="sex" value="<%=session.getAttribute("sex") %>">
                    <label>学号</label>
                    <input type="text" class="span12" id="sex" value="<%=session.getAttribute("sid") %>">
                    <label>专业</label>
                    <input type="text" class="span12" id="major" value="<%=session.getAttribute("major") %>">
                    <label>班级</label>
                    <input type="text" class="span12" id = "class" value="<%=session.getAttribute("class") %>">
                    <label>电话</label>
                    <input type="text" class="span12" id="phone" value="<%=session.getAttribute("phone") %>">
                    <label>邮箱</label>
                    <input type="text" class="span12" id="email" value="<%=session.getAttribute("email") %>">
                    <label>入学年份</label>
                    <input type="text" class="span12" id="intime" value="<%=session.getAttribute("intime") %>">
                    <label>毕业年份</label>
                    <input type="text" class="span12" id="outtime" value="<%=session.getAttribute("outtime") %>">
                    <label>住址</label>
                    <input type="text" class="span12" id="city" value="<%=session.getAttribute("city") %>">
                    
                    <a href="index.jsp" class="btn btn-primary pull-right">返回主页</a>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>





        <script src="lib/bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript">
        
            $("[rel=tooltip]").tooltip();
            $(function() {
                $('.demo-cancel-click').click(function(){return false;});
            });
        </script>

</body>
</html>

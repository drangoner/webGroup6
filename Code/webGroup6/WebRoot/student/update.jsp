<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>信息修改</title>
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

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="#"><span class="first">信息</span> <span class="second">修改</span></a>
        </div>
    </div>
    


    

    
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">修改</p>
            <div class="block-body">
                <form action="../servlet/StuUpdateServlet" method="post">
                    <label>姓名</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("name")%>" />
                    <label>专业</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("major")%>" />
                    <label>班级</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("class")%>" />
                    <label>电话</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("phone")%>" />
                    <label>邮箱</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("email")%>" />
                    <label>入学年份</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("intime")%>" />
                    <label>毕业年份</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("outtime")%>" />
                    <label>住址</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("city")%>" />
                    <label>密码</label>
                    <input type="text" class="span12" value="<%=session.getAttribute("passwd")%>" />
                    <input hidden  name ="sid" value = "<%=session.getAttribute("sid")%>" />
                    <input type="submit" class="btn btn-primary pull-right" value="修改!" />
                    <a href="./index.jsp" class="btn btn-primary pull-left">返回</a>
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
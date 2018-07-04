<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>登记详细信息</title>
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
                <a class="brand" href="#"><span class="first">登记</span> <span class="second">信息</span></a>
        </div>
    </div>
    

    <%

    String name="";
    String major="";
    String classes="";
    String phone="";
    String email="";
    String intime="";
    String outtime="";
    String city="";
    String passwd="";
    String sex="";
	if(session.getAttribute("name")!=null) name = (String)session.getAttribute("name");
	if(session.getAttribute("major")!=null) major = (String)session.getAttribute("major");
	if(session.getAttribute("class")!=null) classes = (String)session.getAttribute("class");
	if(session.getAttribute("phone")!=null) phone = (String)session.getAttribute("phone");
	if(session.getAttribute("email")!=null) email = (String)session.getAttribute("email");
	if(session.getAttribute("intime")!=null) intime = (String)session.getAttribute("intime");
	if(session.getAttribute("outime")!=null) outtime = (String)session.getAttribute("outtime");
	if(session.getAttribute("city")!=null) city = (String)session.getAttribute("city");
	if(session.getAttribute("sex")!=null) sex = (String)session.getAttribute("sex");

    %>
    

    
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">登记</p>
            <div class="block-body">
                <form action="../servlet/StuRegistDetailServlet" method="post">
                    <label>姓名</label>
                    <input type="text" class="span12" name="name"  />
                    <label>性别</label>
                    <input type="text" class="span12" name="sex"  />
                    <label>专业</label>
                    <input type="text" class="span12" name="major"  />
                    <label>班级</label>
                    <input type="text" class="span12" name="class"  />
                    <label>电话</label>
                    <input type="text" class="span12" name="phone"  />
                    <label>邮箱</label>
                    <input type="text" class="span12" name="email"  />
                    <label>入学年份</label>
                    <input type="text" class="span12" name="intime" />
                    <label>毕业年份</label>
                    <input type="text" class="span12" name="outtime"  />
                    <label>住址</label>
                    <input type="text" class="span12" name="city" />
                   
                    <input hidden name="sid" value="<%=session.getAttribute("sid")%>" />
                 
                    <input type="submit" class="btn btn-primary pull-right" value="提交!" />
               
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
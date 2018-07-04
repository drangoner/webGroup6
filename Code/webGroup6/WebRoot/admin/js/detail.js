 /*

@Name：不落阁后台模板源码 
@Author：Absolutely 
@Site：http://www.lyblogs.cn

*/


   

layui.define(['laypage', 'layer', 'form', 'pagesize'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form(),
        laypage = layui.laypage;
    var laypageId = 'pageNav';
    
    var data = null;
    loadData();
    
    function loadData(){
    	
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
    				initilData(1,8,data);
    			}else{
    				console.log("error");
    			}
    			
    		}
    	}
    	xmlhttp.open("GET","../../servlet/StuDetailServlet?sid="+sid,true);
    	xmlhttp.send();
    	
    }

    //页数据初始化
    //currentIndex：当前也下标
    //pageSize：页容量（每页显示的条数）
    function initilData(currentIndex, pageSize,da) {
        var index = layer.load(1);
        //模拟数据
        console.log(da);
        var json = JSON.parse(da);
        console.log(json);
        var data = json.student;
        /*var data = new Array();
        for (var i = 0; i < 30; i++) {
            data.push({ id: i + 1, time: '2017-3-26 15:56', name: '于坤龙', phone: '18720977970', qq: '1181281178', major:'计算机科学与技术'});
        }
        console.log(data);*/
        //模拟数据加载
        setTimeout(function () {
            layer.close(index);
            //计算总页数（一般由后台返回）
            pages = Math.ceil(data.length / pageSize);
            //模拟数据分页（实际上获取的数据已经经过分页）
            var skip = pageSize * (currentIndex - 1);
            var take = skip + Number(pageSize);
            data = data.slice(skip, take);
            var html = '';  //由于静态页面，所以只能作字符串拼接，实际使用一般是ajax请求服务器数据
            html += '<table style="" class="layui-table" lay-even>';
            html += '<colgroup><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"></colgroup>';
            html += '<thead><tr><th>上次登录时间</th><th>姓名</th><th>电话</th><th>E-mail</th><th>入学年份</th><th>毕业年份</th><th>就业单位</th></tr></thead>';
            html += '<tbody>';
            //遍历文章集合
            var item = data[0];
                html += "<tr>";
                html += "<td>" + item.lastlogin + "</td>";
                html += "<td>" + item.name + "</td>";
                html += "<td>" + item.phone + "</td>";
                html += "<td>" + item.email + "</td>";
               
                html += "<td>" + item.intime + "</td>";
                html += "<td>" + item.outtime + "</td>";
                html += "<td>" + item.company + "</td>";
                html += "</tr>";
            html += '</tbody>';
            html += '</table>';
            ////////////////////////////////////////////////
            html += '<table style="" class="layui-table" lay-even>';
            html += '<colgroup><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"></colgroup>';
            html += '<thead><tr><th>性别</th><th>学号</th><th>专业</th><th>班级</th><th>城市</th><th>用户名</th><th>密码</th></tr></thead>';
            html += '<tbody>';
            
            html += "<tr>";
            var sex = item.sex ==1 ?"女":"男";
            html += "<td>" + sex + "</td>";
            html += "<td>" + item.sid + "</td>";
            html += "<td>" + item.major + "</td>";
            html += "<td>" + item.class + "</td>";
            html += "<td>" + item.city + "</td>";
            html += "<td>" + item.user + "</td>";
            html += "<td>" + item.passwd + "</td>";
            html += "</tr>";
        html += '</tbody>';
        html += '</table>';
            
            
            html += '<div id="' + laypageId + '"></div>';

            $('#dataContent').html(html);
            console.log("hahah");
            form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
            $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox

            laypage({
                cont: laypageId,
                pages: pages,
                groups: 8,
                skip: true,
                curr: currentIndex,
                jump: function (obj, first) {
                    var currentIndex = obj.curr;
                    if (!first) {
                        initilData(currentIndex, pageSize,da);
                    }
                }
            });
            //该模块是我定义的拓展laypage，增加设置页容量功能
            //laypageId:laypage对象的id同laypage({})里面的cont属性
            //pagesize当前页容量，用于显示当前页容量
            //callback用于设置pagesize确定按钮点击时的回掉函数，返回新的页容量
            layui.pagesize(laypageId, pageSize).callback(function (newPageSize) {
                //这里不能传当前页，因为改变页容量后，当前页很可能没有数据
                initilData(1, newPageSize,da);
            });
        }, 500);
    }
    
    function showDetail(da){
    	 var json = JSON.parse(da);
         console.log(json);
         var data = json.student;
         
         setTimeout(function () {
             var html = '';  //由于静态页面，所以只能作字符串拼接，实际使用一般是ajax请求服务器数据
             html += '<table style="" class="layui-table" lay-even>';
             html += '<colgroup><col width="180"><col width="150"><col width="150"><col width="180"><col width="180"><col width="180"><col width="180"><col width="180"><col width="90"><col width="90"><col width="50"><col width="50"></colgroup>';
             html += '<thead><tr><th>上次登录时间</th><th>姓名</th><th>电话</th><th>QQ</th><th>专业</th><th>入学年份</th><th>毕业年份</th><th>就业单位</th><th colspan="2">操作</th></tr></thead>';
             html += '<tbody>';
             //遍历文章集合
             for (var i = 0; i < data.length; i++) {
                 var item = data[i];
                 html += "<tr>";
                 html += "<td>" + item.lastlogin + "</td>";
                 html += "<td>" + item.name + "</td>";
                 html += "<td>" + item.phone + "</td>";
                 html += "<td>" + item.email + "</td>";
                 html += "<td>" + item.major + "</td>";
                 html += "<td>" + item.intime + "</td>";
                 html += "<td>" + item.outtime + "</td>";
                 html += "<td>" + item.company + "</td>";
                // html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="置顶" value="' + item.id + '" lay-filter="top" checked /></div></form></td>';
                // html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="推荐" value="' + item.id + '" lay-filter="recommend" checked /></div></form></td>';
                 html += '<td><button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData(\'' + item.id + '\')"><i class="layui-icon">&#xe63c;</i></button></td>';
                 html += '<td><button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.datalist.deleteData(\'' + item.id + '\')"><i class="layui-icon">&#xe640;</i></button></td>';
                 html += "</tr>";
             }
             html += '</tbody>';
             html += '</table>';
             html += '<div id="' + laypageId + '"></div>';

             $('#dataContent').html(html);
            
         }, 500);
    }
    
    
    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                layer.msg('删除Id为【' + id + '】的数据');
            }, function () {

            });
        },
        editData: function (sid) {
            detail(sid);
        }
    };


    exports('detail', datalist);
});
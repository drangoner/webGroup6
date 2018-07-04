package servlet;

import group6.DAOFactory;
import group6.Stu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuSignUpServlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		String path = "../student/regist.jsp";
		String user = request.getParameter("user");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		String sid = request.getParameter("sid");
		
		//Map<String,String> studentInfo = new HashMap<String,String>();
		List<String> info  = new ArrayList<String>();
		if(user == null || "".equals(user)){
			info.add("用户名为空！");
			
		}
		if(passwd == null || "".equals(passwd)){
			info.add("密码为空!");
		
		}
		if(passwd2 == null || "".equals(passwd2) || !passwd.equals(passwd2)){
			info.add("确认密码为空！或者两次密码不一样");
			
		}
		if(sid == null || "".equals(sid)){
			info.add("学号为空!");
		
		}
		if(info.size()==0){
			Stu student = new Stu();
			student.setUser(user);
			student.setPasswd(passwd);
			student.setSid(sid);
			
			try{
				if(DAOFactory.getIStuDAOInstanse().regist(student)){
					
					//studentInfo.put("name", student.getName());
					//info.add("鐢ㄦ埛鐧诲綍鎴愬姛");
					//request.setAttribute("studentInfo", studentInfo);
					request.setAttribute("regist", 1);
					request.setAttribute("user",user);
					request.setAttribute("sid",sid);
					request.setAttribute("passwd",passwd);
				}else{
					info.add("鐢ㄦ埛鐧诲綍澶辫触锛岄敊璇殑鐢ㄦ埛鍚嶅拰瀵嗙爜锛?");
					request.setAttribute("fail","注册失败");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}



}

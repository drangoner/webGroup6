package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group6.*;

public class AdminLoginServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,IOException{
		
		req.setCharacterEncoding("utf8");
		String path = "login.jsp";
		
		
		
		String user = req.getParameter("user");
		String passwd = req.getParameter("passwd");
		
		
		Map<String,String> adminInfo = new HashMap<String,String>();
		List<String> info  = new ArrayList<String>();
		if(user == null || "".equals(user)){
			info.add("鐢ㄦ埛鍚嶄笉鑳戒负绌猴紒");
			
		}
		if(passwd == null || "".equals(passwd)){
			info.add("瀵嗙爜涓嶈兘涓虹┖!");
		
		}
		if(info.size()==0){
			Admin admin = new Admin();
			admin.setUser(user);
			admin.setPasswd(passwd);
			try{
				if(DAOFactory.getIAdminDAOInstanse().findLogin(admin)){//楠岃瘉閫氳繃
					
					adminInfo.put("name", admin.getName());
					adminInfo.put("lastlogin", admin.getLastLogin());
					
					String[] value = new String[2];
					if(DAOFactory.getIStuDAOInstanse().getTotalNum(value)){
						adminInfo.put("usernum", value[0]);
					}else{
						System.out.println("something is wrong here ....");
					}
					info.add("鐢ㄦ埛鐧诲綍鎴愬姛");
					req.setAttribute("adminInfo", adminInfo);
					req.setAttribute("login", 1);
					req.setAttribute("user",user);
				}else{
					info.add("鐢ㄦ埛鐧诲綍澶辫触锛岄敊璇殑鐢ㄦ埛鍚嶅拰瀵嗙爜锛?");
					req.setAttribute("fail","登录失败用户名或密码错误");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		req.setAttribute("info", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		this.doGet(req, resp);
	}
}

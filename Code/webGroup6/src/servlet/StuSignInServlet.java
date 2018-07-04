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

public class StuSignInServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StuSignInServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "/student/sign-in.jsp";
		String user = request.getParameter("user");
		String passwd = request.getParameter("passwd");
		Map<String,String> StuInfo = new HashMap<String,String>();
		List<String> info  = new ArrayList<String>();
		if(user == null || "".equals(user)){
			info.add("用户名不能为空");
			
		}
		if(passwd == null || "".equals(passwd)){
			info.add("密码不能为空");
		
		}
		if(info.size()==0){
			
			Stu stu = new Stu();
			stu.setUser(user);
			stu.setPasswd(passwd);
			
			try{
				if(DAOFactory.getIStuDAOInstanse().findLogin(stu)){
					
					StuInfo.put("name", stu.getName());
					StuInfo.put("lastlogin", stu.getLastlogin());
					StuInfo.put("sid", stu.getSid());
					StuInfo.put("email", stu.getEmail());
					StuInfo.put("phone", stu.getPhone());
					StuInfo.put("intime", stu.getIntime());
					StuInfo.put("outtime", stu.getOuttime());
					StuInfo.put("city", stu.getCity());
					StuInfo.put("sex", ""+stu.getSex());
					StuInfo.put("class", stu.getSclass());
					StuInfo.put("major", stu.getMajor());
					StuInfo.put("company", stu.getCompany());
					
					info.add("登陆成功");
					request.setAttribute("StuInfo", StuInfo);
					request.setAttribute("login", 1);
					request.setAttribute("user",user);
					request.setAttribute("passwd",passwd);
				}else{
					info.add("登陆失败");
					request.setAttribute("fail","用户名或密码错误");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

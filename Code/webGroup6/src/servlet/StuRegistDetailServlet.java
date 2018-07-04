package servlet;

import group6.DAOFactory;
import group6.Stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StuRegistDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StuRegistDetailServlet() {
		super();
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
			
			request.setCharacterEncoding("utf8");
			Stu stu = new Stu();
			
			String sex = request.getParameter("sex");
			int s = sex.equals("男")?0:1;
			stu.setSex(s);
			stu.setName(request.getParameter("name"));
			stu.setSid(request.getParameter("sid"));
			stu.setMajor(request.getParameter("major"));
			stu.setSclass(request.getParameter("class"));
			stu.setPhone(request.getParameter("phone"));
			stu.setEmail(request.getParameter("email"));
			stu.setIntime(request.getParameter("intime"));
			stu.setOuttime(request.getParameter("outtime"));
			stu.setCity(request.getParameter("city"));
			try {
				if(DAOFactory.getIStuDAOInstanse().registdetail(stu)){
					HttpSession session = request.getSession();
					session.setAttribute("name",stu.getName());
		      		session.setAttribute("lastlogin",stu.getLastlogin());
		      		session.setAttribute("sid", stu.getSid());
		      		session.setAttribute("sex", sex);
		      		session.setAttribute("major", stu.getMajor());
		      		session.setAttribute("class", stu.getSclass());
		      		session.setAttribute("intime",stu.getIntime());
		      		session.setAttribute("outtime", stu.getOuttime());
		      		session.setAttribute("city", stu.getCity());
		      		session.setAttribute("phone", stu.getPhone());
		      		session.setAttribute("email", stu.getEmail());
		      		session.setAttribute("company",stu.getCompany());
		      		session.setAttribute("user", "user");
					response.sendRedirect("../student/index.jsp");
				}else{
					response.sendRedirect("../student/regist_detail.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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

}

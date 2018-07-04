package servlet;

import group6.DAOFactory;
import group6.Stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StuUpdateServlet() {
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
		stu.setName(request.getParameter("name"));
		stu.setSid(request.getParameter("sid"));
		stu.setMajor(request.getParameter("major"));
		stu.setSclass(request.getParameter("class"));
		stu.setPhone(request.getParameter("phone"));
		stu.setEmail(request.getParameter("email"));
		stu.setIntime(request.getParameter("intime"));
		stu.setOuttime(request.getParameter("outtime"));
		stu.setCity(request.getParameter("city"));
		stu.setPasswd(request.getParameter("passwd"));
		try {
			if(DAOFactory.getIStuDAOInstanse().update(stu)){
				response.sendRedirect("../student/index.jsp");
			}else{
				response.sendRedirect("../student/update.jsp");
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

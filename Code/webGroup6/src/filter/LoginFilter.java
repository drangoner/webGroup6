package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	public void init(FilterConfig config) throws ServletException{
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession ses = req.getSession();
		if(ses.getAttribute("user")!=null){
			chain.doFilter(request,response);
		}else{
			request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
		}
	}
	public void destroy(){
		
	}
}

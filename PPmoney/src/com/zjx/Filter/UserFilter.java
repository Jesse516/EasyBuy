package com.zjx.Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.User;

public class UserFilter implements Filter{
	private List<String> allowedList = Arrays.asList("/AddAddress.Action","/CommentShow2.Action");
	public void destroy() {
		// TODO Auto-generated method stub	
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String path = request.getServletPath();
		User user=(User)request.getSession().getAttribute("user");
		if(path.startsWith("/manage")){
			if(user==null){
				response.sendRedirect("../login.jsp");
			}else if(user.getStatus()==1){
				response.sendRedirect("../login.jsp");
			}else{
				arg2.doFilter(arg0, arg1);
			}
		}else if(allowedList.contains(path)){
			if(user==null){
				response.sendRedirect("login.jsp");
			}else{
				arg2.doFilter(arg0, arg1);
			}
		}else{
			arg2.doFilter(arg0, arg1);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjx.Entity.User;
import com.zjx.Service.Impl.UserServiceImpl;
import com.zjx.util.MD5;

public class LoginAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
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

		doPost(request,response);
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

		HttpSession session = request.getSession(); 
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		password=new MD5(password).compute();
		String authImg=(String)request.getSession().getAttribute("authImg");
		String code=request.getParameter("code");
		UserServiceImpl usi = new UserServiceImpl();
		if(authImg.equals(code)){
			User user=usi.findCertainUser(userId, password);
			if(user!=null){
				session.setAttribute("userId",userId);
				session.setAttribute("user",user);
				request.getRequestDispatcher("main.Action").forward(request,response);
			}else{
				request.setAttribute("msg","用户名或密码输入错误");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}else{
			request.setAttribute("msg1","验证码不正确");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	
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

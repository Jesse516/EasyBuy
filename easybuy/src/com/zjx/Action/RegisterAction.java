package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.User;
import com.zjx.Service.Impl.UserServiceImpl;
import com.zjx.util.MD5;

public class RegisterAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterAction() {
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
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		password = new MD5(password).compute();
		String confirmPassword=request.getParameter("confirmPassword");
		confirmPassword = new MD5(confirmPassword).compute();
		String sex=request.getParameter("sex");
		String sex1="";
		if(sex.equals("male")){
			sex1="M";
		}else{
			sex1="F";
		}
		String birthday=request.getParameter("birthday");
		Date date=Date.valueOf(birthday);

		String identityCode=request.getParameter("identityCode");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address = request.getParameter("address");	
		Integer type=1;    //1是普通用户,2是管理员;
		Integer status=1;  //status 0是未激活或者删除，1是已激活;
		User user = new User(userId,userName,password,sex1,date,identityCode,email,mobile,address,type,status);
		if(password.equals(confirmPassword)){
			UserServiceImpl usi = new UserServiceImpl();
			int result=usi.addUser(user);
			if(result>0){
				request.getRequestDispatcher("reg-result.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "两次密码输入不同");
			request.setAttribute("user",user);				
			request.getRequestDispatcher("register.jsp").forward(request, response);
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

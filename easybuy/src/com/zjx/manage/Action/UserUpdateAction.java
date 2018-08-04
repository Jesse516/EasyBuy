package com.zjx.manage.Action;

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

public class UserUpdateAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserUpdateAction() {
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

		String userName=request.getParameter("userName");
		String name=request.getParameter("name");
		String passWord=request.getParameter("passWord");
		passWord = new MD5(passWord).compute();
		String rePassword=request.getParameter("rePassWord");
		rePassword = new MD5(rePassword).compute();
		String sex=request.getParameter("sex");
		if(sex.equals("M")){
			sex="M";
		}else{
			sex="F";
		}
		String birthyear=request.getParameter("birthyear");
		String birthmonth=request.getParameter("birthmonth");
		String birthday=request.getParameter("birthday");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String day=birthyear+"-"+birthmonth+"-"+birthday;
		Date date=Date.valueOf(day);
		if(passWord.equals(rePassword)){
			User user = new User(userName,name,passWord,sex,date,null,null,mobile,address,1,1);
			UserServiceImpl usi = new UserServiceImpl();
			int result=usi.updateUserById(user);
			if(result>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "两次密码输入不一致");
			request.getRequestDispatcher("user-modify.jsp").forward(request, response);
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

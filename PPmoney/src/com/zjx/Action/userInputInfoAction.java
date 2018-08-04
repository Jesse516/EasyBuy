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

public class userInputInfoAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public userInputInfoAction() {
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

		UserServiceImpl usi = new UserServiceImpl();
		String surName=request.getParameter("surName");
		String card="";
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String rePassword=request.getParameter("rePassword");
		if(password.equals(rePassword)){
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String day=request.getParameter("day");
			String birthday=year+"-"+month+"-"+day;
			String email=request.getParameter("email");
			String occupation=request.getParameter("occupation");
			Date date = new Date(System.currentTimeMillis());
			User user = new User(surName,card,phone,password,birthday,email,occupation,date.toString(),0,0);
			int result=usi.inputUserInfo(user);
			if(result!=0){
				request.setAttribute("user", user);
				request.getRequestDispatcher("cardRegister.jsp").forward(request, response);
			}
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

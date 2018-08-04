package com.zjx.manage.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.Category;
import com.zjx.Service.Impl.CategoryServiceImpl;

public class CategoryAddParentAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CategoryAddParentAction() {
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
		
		CategoryServiceImpl csi = new CategoryServiceImpl();
		String className=request.getParameter("className");
		System.out.print(className);
		String p=request.getParameter("parentId");
		String g=request.getParameter("hhh");
		if(g.equals("pb")){
			int parentId=Integer.parseInt(p);
			int result=csi.addChildName(parentId, className);
			if(result>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}
		}else if(g.equals("pe")){
			int result=csi.addParentName(className);
			if(result>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
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

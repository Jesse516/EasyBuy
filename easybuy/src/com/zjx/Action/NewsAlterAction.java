package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjx.Entity.News;
import com.zjx.Service.Impl.NewsServiceImpl;

public class NewsAlterAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsAlterAction() {
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

		String title=request.getParameter("title");
		title = new String(title.getBytes("iso-8859-1"),"utf-8");
		String content=request.getParameter("content");
		content = new String(content.getBytes("iso-8859-1"),"utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		Timestamp date = new Timestamp(System.currentTimeMillis());
		News news = new News(id,title,content,date);
		NewsServiceImpl nsi = new NewsServiceImpl();
		int result=nsi.alterNews(news);
		if(result>0){
			request.getRequestDispatcher("manage-result.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("news-add.jsp").forward(request,response);
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

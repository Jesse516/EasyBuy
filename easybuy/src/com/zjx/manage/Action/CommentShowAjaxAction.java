package com.zjx.manage.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zjx.Entity.Comment;
import com.zjx.Service.Impl.CommentServiceImpl;

public class CommentShowAjaxAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommentShowAjaxAction() {
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
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out =response.getWriter();
		int pageNo=1;
		int pageSize=3;
		List<Comment> li = new ArrayList<Comment>();
		CommentServiceImpl csi = new CommentServiceImpl();
		String p=request.getParameter("pageNo");
		if(p!=null){
			pageNo = Integer.parseInt(p);
		}
		li=csi.showAllCommentByPage(pageNo, pageSize);
		int countPage=csi.countPageByComment(pageSize);
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("countPage",countPage);
		map.put("li",li);
		
		String str = JSONObject.toJSONString(map);
		out.print(str);
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

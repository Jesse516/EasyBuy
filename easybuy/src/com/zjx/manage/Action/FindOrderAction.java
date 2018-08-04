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

import com.alibaba.fastjson.JSONArray;
import com.zjx.Entity.Order;
import com.zjx.Entity.OrderDetail;
import com.zjx.Service.Impl.OrderServiceImpl;

public class FindOrderAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindOrderAction() {
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
		
		/*int pageNo=1;
		int pageSize=2;
		if(p_no!=null){
			pageNo=Integer.parseInt(p_no);
		}
		String orderId=request.getParameter("orderId");
		String userId=request.getParameter("userId");
		OrderServiceImpl osi = new OrderServiceImpl();
		int countPage=osi.countOrderAmount(orderId, userId, pageSize);
		Map<Order,List<OrderDetail>> map=osi.findByPage(orderId, userId, pageNo, pageSize);
		request.setAttribute("countPage", countPage);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("map", map);
		request.setAttribute("orderId", orderId);
		request.setAttribute("userId", userId);*/
		
		String orderId=request.getParameter("orderId");
		String userId=request.getParameter("userId");
		int pageNo=1;
		int pageSize=2;
		Map<Order,List<OrderDetail>> map = new LinkedHashMap<Order,List<OrderDetail>>();
		
		OrderServiceImpl osi = new OrderServiceImpl();
		map=osi.findByPage(orderId, userId, pageNo, pageSize);
		request.setAttribute("map", map);
		request.getRequestDispatcher("order1.jsp").forward(request, response);
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

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
import com.zjx.Entity.Product;
import com.zjx.Service.Impl.ProductServiceImpl;

public class ProductShowAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProductShowAction() {
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
		
		int pageNo=1;
		int pageSize=3;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		List<Product> li = new ArrayList<Product>();
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		PrintWriter out = response.getWriter();
		String p=request.getParameter("pageNo");
		if(p!=null){
			pageNo=Integer.parseInt(p);
		}
		ProductServiceImpl psi = new ProductServiceImpl();
		int countPage=psi.countPageByProduct(pageSize);
		li = psi.showAllUserByPage(pageNo, pageSize);
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

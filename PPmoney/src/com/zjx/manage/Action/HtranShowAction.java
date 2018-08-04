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
import com.zjx.Entity.Htran;
import com.zjx.Entity.Product;
import com.zjx.Service.Impl.HtranServiceImpl;
import com.zjx.Service.Impl.ProductServiceImpl;

public class HtranShowAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HtranShowAction() {
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
		PrintWriter out = response.getWriter();
		int pageNo=1;
		int pageSize=3;
		int countPage=0;
		List<Htran> li = new ArrayList<Htran>();
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String p=request.getParameter("pageNo");
		if(p!=null){
			pageNo=Integer.parseInt(p);
		}
		HtranServiceImpl hsi = new HtranServiceImpl();
		String sf=request.getParameter("sf");
		if("0".equals(sf)){
			li=hsi.showAllCHtranByPage(pageNo, pageSize);
			countPage=hsi.countPageByCHtran(pageSize);
		}else if("1".equals(sf)){
			li=hsi.showAllUHtranByPage(pageNo, pageSize);
			countPage=hsi.countPageByUHtran(pageSize);
		}
		map.put("countPage", countPage);
		map.put("li", li);
		String str=JSONObject.toJSONString(map);
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

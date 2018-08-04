package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.Category;
import com.zjx.Entity.News;
import com.zjx.Entity.Product;
import com.zjx.Service.Impl.CategoryServiceImpl;
import com.zjx.Service.Impl.NewsServiceImpl;
import com.zjx.Service.Impl.ProductServiceImpl;

public class mainAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public mainAction() {
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
		List<News> li = new ArrayList<News>();
		List<Category> pli = new ArrayList<Category>();
		List<Category> cli = new ArrayList<Category>();
		List<Product> prli = new ArrayList<Product>();
		Map<Category,List<Category>> map = new LinkedHashMap<Category,List<Category>>();
		NewsServiceImpl nsi = new NewsServiceImpl();
		li=nsi.showNews();
		CategoryServiceImpl csi = new CategoryServiceImpl();
		pli=csi.findAllParentName();
		for(Category p:pli){
			cli=csi.findChildByParent(p.getId());
			map.put(p,cli);
		}
		ProductServiceImpl psi = new ProductServiceImpl();
		prli=psi.showAllProduct();
		request.setAttribute("prli",prli);
		request.setAttribute("li", li);
		request.setAttribute("map",map);
		
		Cookie[] cookie = request.getCookies();
		String value="";
		if(cookie!=null){
			for(Cookie c:cookie){
				if(c.getName().equals("recentList")){
					value=c.getValue();
					break;
				}
			}
		}	
		
		String[] arr = value.split(",");
		List<Product> latelyList = psi.findLately(arr);
		request.setAttribute("latelyList", latelyList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
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

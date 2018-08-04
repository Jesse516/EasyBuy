package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.Product;
import com.zjx.Service.Impl.ProductServiceImpl;

public class FindProductByIdAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindProductByIdAction() {
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
		
		String i=request.getParameter("id");
		if(i!=null){
			String value="";
			int id = Integer.parseInt(i);
			ProductServiceImpl psi = new ProductServiceImpl();
			Product product=psi.findProductById(id);
			request.setAttribute("product", product);
		
			LinkedList<String> li=new LinkedList<String>();
			Cookie[] cookie = request.getCookies();
			if(cookie.length!=1){
				for(Cookie c:cookie){
					if(c.getName().equals("recentList")){
						value=c.getValue();
						break;
					}
				}
				String[] arr = value.split(",");
				Collection<String> coll=Arrays.asList(arr);
				li = new LinkedList<String>(coll);
				if(li.size()<5){
					if(li.contains(id+"")){
						li.remove(id+"");
					}
					li.addFirst(id+"");
				}else{
					if(li.contains(id+"")){
						li.remove(id+"");
						li.addFirst(id+"");
					}else{
						li.removeLast();
						li.addFirst(id+"");
					}
				}	
				
			}else{
				li.add(id+"");
			}
			
			StringBuffer sb= new StringBuffer();
			for(String s:li){
				sb.append(s+",");
			}
			String str = sb.toString();
			value = str.substring(0,str.length()-1);
			
			Cookie cookies = new Cookie("recentList",value);
			cookies.setMaxAge(60*60*7*24);
			response.addCookie(cookies);
			
			request.setAttribute("cookies", cookies);
			request.getRequestDispatcher("product-view.jsp").forward(request,response);
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

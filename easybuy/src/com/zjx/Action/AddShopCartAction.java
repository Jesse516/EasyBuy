package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.Product;
import com.zjx.Entity.SaleLine;
import com.zjx.Entity.ShopCart;
import com.zjx.Service.Impl.ProductServiceImpl;

public class AddShopCartAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddShopCartAction() {
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

		ProductServiceImpl psi = new ProductServiceImpl();
		String i=request.getParameter("id");
		if(i!=null){
			int id = Integer.parseInt(i);
			Product product=psi.findProductById(id);
			ShopCart sc = (ShopCart) request.getSession().getAttribute("sc");
			if(sc==null){
				sc = new ShopCart();
				request.getSession().setAttribute("sc",sc);
			}
			SaleLine sl =new SaleLine();
			sl.setProduct(product);
			sc.add(sl);
			response.sendRedirect("shopping.jsp");
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

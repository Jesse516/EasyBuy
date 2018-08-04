package com.zjx.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjx.Entity.Order;
import com.zjx.Entity.OrderDetail;
import com.zjx.Entity.Product;
import com.zjx.Entity.SaleLine;
import com.zjx.Entity.ShopCart;
import com.zjx.Service.Impl.OrderDetailServiceImpl;
import com.zjx.Service.Impl.OrderServiceImpl;
import com.zjx.Service.Impl.ProductServiceImpl;

public class UpdateMenusoonAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMenusoonAction() {
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
		
		OrderDetailServiceImpl odsi = new OrderDetailServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		int num=Integer.parseInt(request.getParameter("num"));
		ProductServiceImpl psi = new ProductServiceImpl();
		Product product=psi.findProductById(id);
		if(product.getAmount()>=num){
			Order order = new Order();
			String orderId = UUID.randomUUID().toString().replace("-",""); 
			order.setOrderId(orderId);
			order.setUserId((String)request.getSession().getAttribute("userId"));
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			order.setCreateTime(ts);
			order.setStatus(1);
			order.setIsDelete(1);
			OrderServiceImpl osi = new OrderServiceImpl();
			osi.addOrder(order);
			
			ShopCart sc=(ShopCart)request.getSession().getAttribute("sc");
			List<SaleLine> lines=sc.getLines();
			OrderDetail od = new OrderDetail();
			for(SaleLine line:lines){
				od.setOrderId(orderId);
				od.setProductId(line.getProduct().getId());
				od.setAmount(num);
				od.setIsDelete(1);
				odsi.addOrderDetail(od);
				Product p=psi.findProductById(line.getProduct().getId());
				p.setAmount(p.getAmount()-num);
				psi.updateProduct(p);
			}
			request.getRequestDispatcher("shopping-result.jsp").forward(request,response);
			
		}else{
			//ÊýÁ¿²»×ã
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

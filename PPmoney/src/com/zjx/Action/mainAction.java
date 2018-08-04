package com.zjx.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zjx.Entity.Cases;
import com.zjx.Entity.Product;
import com.zjx.Entity.News;
import com.zjx.Service.Impl.CasesServiceImpl;
import com.zjx.Service.Impl.ProductServiceImpl;
import com.zjx.Service.Impl.NewsServiceImpl;

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

		List<Product> pli = new ArrayList<Product>();
		List<Product> pli2 = new ArrayList<Product>();
		List<Cases> cli = new ArrayList<Cases>();
		List<News> nli = new ArrayList<News>();
		ProductServiceImpl psi = new ProductServiceImpl();
		CasesServiceImpl csi = new CasesServiceImpl();
		NewsServiceImpl nsi = new NewsServiceImpl();
		pli=psi.showAllInvestment();
		pli2=psi.showAllLoan();
		cli=csi.showAllCases();
		nli = nsi.findAllNews(2);
		request.setAttribute("pli",pli);
		request.setAttribute("pli2",pli2);
		request.setAttribute("cli",cli);
		request.setAttribute("nli",nli);
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

package com.zjx.manage.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zjx.Service.Impl.HtranServiceImpl;
import com.zjx.Service.Impl.ProductServiceImpl;
import com.zjx.Service.Impl.UserServiceImpl;

public class manageMainAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public manageMainAction() {
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
		
		UserServiceImpl usi = new UserServiceImpl();
		ProductServiceImpl psi = new ProductServiceImpl();
		HtranServiceImpl hsi = new HtranServiceImpl();
		int aResult=usi.countAllUser();
		int bResult=usi.countBindUser();
		
		int aInvestment=psi.countAllInvestment();
		int bInvestment=psi.countFullInvestment();
		
		int aLoan=psi.countAllLoan();
		int bLoan=psi.countFullLoan();
		
		int aHtran=hsi.countAllHtran();
		int bHtran=hsi.countTodayHtran();
		
		Double aMoney=hsi.allMoney();
		Double bMoney=hsi.todayMoney();
		
		request.setAttribute("aResult",aResult);
		request.setAttribute("bResult",bResult);
		request.setAttribute("aInvestment",aInvestment);
		request.setAttribute("bInvestment",bInvestment);
		request.setAttribute("aLoan",aLoan);
		request.setAttribute("bLoan",bLoan);
		request.setAttribute("aMoney",aMoney);
		request.setAttribute("bMoney",bMoney);
		request.setAttribute("aHtran",aHtran);
		request.setAttribute("bHtran",bHtran);
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

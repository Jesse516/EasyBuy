package com.zjx.manage.Action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zjx.Entity.Product;
import com.zjx.Service.Impl.ProductServiceImpl;

public class ProductUpdateAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProductUpdateAction() {
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
		String productName="";
		String productDetail="";
		int parentId=0;
		int childId=0;
		double productPrice=0;
		int productNumber=0;
		String fileName="";
		int id=0;
		ServletContext sc = this.getServletContext();
		
		String i=request.getParameter("id");
		if(i!=null){
			id = Integer.parseInt(i);
		}
		
		List<String> allowedType = Arrays.asList("jpg","jpeg","gif");
		ProductServiceImpl psi = new ProductServiceImpl();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> li = upload.parseRequest(request);
			for(FileItem item:li){
				if(item.isFormField()){
					String fname = item.getFieldName();
					if(fname.equals("productName")){
						productName=item.getString("utf-8");
					}else if(fname.equals("productDetail")){
						productDetail=item.getString("utf-8");
					}else if(fname.equals("parentId")){
						parentId = Integer.parseInt(item.getString());
					}else if(fname.equals("childId")){
						childId = Integer.parseInt(item.getString());
					}else if(fname.equals("productPrice")){
						productPrice=Double.parseDouble(item.getString());
					}else if(fname.equals("productNumber")){
						productNumber = Integer.parseInt(item.getString());
					}
				}else{
					if(item!=null){
						fileName = item.getName();
						File file = new File(fileName);
						fileName = file.getName();
						String type = fileName.substring(fileName.lastIndexOf(".")+1);
						if(allowedType.contains(type.toLowerCase())){
							fileName = UUID.randomUUID().toString().replace("-","")+"."+type;
							ServletContext application = this.getServletContext();
							String realPath = application.getRealPath("/images");
							File uploadFile = new File(realPath+"/"+fileName);
							try {
								item.write(uploadFile);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}
				
			}
			Product p = new Product(id,productName,productDetail,childId,productPrice,productNumber,fileName);
			if(p!=null){
				int result=psi.updateProduct(p);
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "上传信息有误");
			request.getRequestDispatcher("product-add.jsp").forward(request, response);
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

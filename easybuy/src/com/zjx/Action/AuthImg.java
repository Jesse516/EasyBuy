package com.zjx.Action;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthImg extends HttpServlet {
	private String flag="0123456789";
	/**
	 * Constructor of the object.
	 */
	public AuthImg() {
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

		doPost(request, response);
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

		response.setContentType("image/jpeg");
		
		int width=80;
		int height=20;
		BufferedImage image=new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		
		Graphics g= image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, width-2, height-2);
		
		g.setColor(Color.BLUE);
		Font font=new Font("ºÚÌå", Font.BOLD, 20);
		g.setFont(font);
		Random random=new Random(System.currentTimeMillis());
		String str="";
		for(int i=0;i<4;i++){
			char ch=flag.charAt(random.nextInt(flag.length()));
			/*Color c=new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
			g.setColor(c);*/
			
			//g.drawString(ch+"", 15+i*15, 18+random.nextInt(5));
			str+=ch;
			
		}
		
		g.drawString(str, 15, 18);
		
		
		/*g.setColor(Color.RED);
		g.drawLine(0, 0, 70, 18);*/
		
		g.dispose();
		
		
		request.getSession().setAttribute("authImg", str);
		
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
		
		
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

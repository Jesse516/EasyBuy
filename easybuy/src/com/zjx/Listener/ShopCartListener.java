package com.zjx.Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.zjx.Entity.ShopCart;

public class ShopCartListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ShopCart sc = new ShopCart();
		session.setAttribute("sc",sc);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

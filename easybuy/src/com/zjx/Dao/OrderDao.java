package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.Order;

public interface OrderDao {
	public int countOrderAmount(String orderId,String userId);
	public List<Order> findOrderByPage(String orderId,String userId,int pageNo,int pageSize);
	public int addOrder(Order order);
	public int updateOrderStatus(int status,String orderId);
}

package com.zjx.Service;

import java.util.List;
import java.util.Map;

import com.zjx.Entity.Order;
import com.zjx.Entity.OrderDetail;

public interface OrderService {
	public int countOrderAmount(String orderId,String userId,int pageSize); 
	public Map<Order,List<OrderDetail>> findByPage(String orderId,String userId,int pageNo, int pageSize);
	public int addOrder(Order order);
	public int updateOrderStatus(int status,String orderId);
}

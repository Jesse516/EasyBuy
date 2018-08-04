package com.zjx.Service.Impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.zjx.Dao.Impl.OrderDaoImpl;
import com.zjx.Dao.Impl.OrderDetailDaoImpl;
import com.zjx.Entity.Order;
import com.zjx.Entity.OrderDetail;
import com.zjx.Service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDaoImpl odi= new OrderDaoImpl();
	private OrderDetailDaoImpl oddi = new OrderDetailDaoImpl(); 
	public int countOrderAmount(String orderId, String userId, int pageSize) {
		// TODO Auto-generated method stub
		int count=odi.countOrderAmount(orderId, userId);
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}

	public Map<Order, List<OrderDetail>> findByPage(String orderId,
			String userId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Order> orderList =odi.findOrderByPage(orderId, userId, pageNo, pageSize);
		Map<Order,List<OrderDetail>> map = new LinkedHashMap<Order,List<OrderDetail>>();
		for(Order order:orderList){
			List<OrderDetail> detailList=oddi.findByOrderId(order.getOrderId());
			double cost=0;
			for(OrderDetail detail:detailList){
				cost+=detail.getTotal();
			}
			order.setCost(cost);
			map.put(order, detailList);
		}
		return map ;
	}

	public int addOrder(Order order) {
		return odi.addOrder(order);
	}

	public int updateOrderStatus(int status, String orderId) {
		return odi.updateOrderStatus(status, orderId);
	}

}

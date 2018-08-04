package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.OrderDetail;

public interface OrderDetailDao {
	public List<OrderDetail> findByOrderId(String orderId);
	public int addOrderDetail(OrderDetail od);
}

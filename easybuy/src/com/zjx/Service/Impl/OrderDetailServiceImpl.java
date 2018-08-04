 package com.zjx.Service.Impl;

import java.util.List;
import java.util.Map;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.Impl.OrderDetailDaoImpl;
import com.zjx.Entity.Order;
import com.zjx.Entity.OrderDetail;
import com.zjx.Service.OrderDetailService;


public class OrderDetailServiceImpl extends BaseDao implements OrderDetailService{
	OrderDetailDaoImpl oddi = new OrderDetailDaoImpl();
	public int addOrderDetail(OrderDetail od) {
		return oddi.addOrderDetail(od);
	}

	

}

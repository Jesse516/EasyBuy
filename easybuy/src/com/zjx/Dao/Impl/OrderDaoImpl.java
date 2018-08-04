 package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.OrderDao;
import com.zjx.Entity.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao{
	Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	public int countOrderAmount(String orderId, String userId) {
		int count=0;
		String sql = "select count(*) from `order` where isDelete=1 ";
		if(orderId!=null && !"".equals(orderId)){
			sql+="and orderId like '%"+orderId+"%'";
		}
		if(userId!=null && !"".equals(userId)){
			sql+="and userId like '%"+userId+"%'";
		}
		con= this.getConnection();
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(con,ps,rs);
		}	
		return count;
	}

	public List<Order> findOrderByPage(String orderId, String userId,int pageNo,int pageSize) {
		List<Order> li = new ArrayList<Order>();
		String sql = "select * from `order` where isDelete=1 ";
		if(orderId!=null && !"".equals(orderId)){
			sql+="and orderId like '%"+orderId+"%'";
		}
		if(userId!=null && !"".equals(userId)){
			sql+="and userId like '%"+userId+"%'";
		}
		sql+="order by createTime desc limit ?,?";
		con= this.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Order order = new Order(rs.getString("orderId"),rs.getString("userId"),rs.getTimestamp("createTime"),rs.getInt("status"),rs.getInt("isDelete"));
				li.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(con,ps,rs);
		}	
		return li;
	}

	public int addOrder(Order order) {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("insert into `order`(orderId,userId,createTime,status,isDelete) values (?,?,?,?,?)");
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getUserId());
			ps.setTimestamp(3, order.getCreateTime());
			ps.setInt(4, order.getStatus());
			ps.setInt(5, order.getIsDelete());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateOrderStatus(int status,String orderId) {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update `order` set status=? where orderId=?");
			ps.setInt(1, status);
			ps.setString(2, orderId);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

}

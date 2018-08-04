package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.OrderDetailDao;
import com.zjx.Entity.OrderDetail;

public class OrderDetailDaoImpl extends BaseDao  implements OrderDetailDao {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		
	public List<OrderDetail> findByOrderId(String orderId) {
		List<OrderDetail> li = new ArrayList<OrderDetail>();
		con = this.getConnection();
		String sql ="select d.id,d.orderId,d.productId,d.amount,d.isDelete,p.name,p.price,p.src from detail d left join product p on d.productId = p.id where d.isDelete=1 AND d.orderId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orderId);
			rs=ps.executeQuery();
			while(rs.next()){
				OrderDetail od = new OrderDetail(rs.getInt("id"),rs.getString("orderId"),rs.getInt("productId"),rs.getInt("amount"),rs.getInt("isDelete"),rs.getString("name"),rs.getString("src"),rs.getDouble("price"));
				li.add(od);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}
	public int addOrderDetail(OrderDetail od) {
		int result=0;
		con = this.getConnection();
		try {
			ps =con.prepareStatement("insert into `detail`(orderId,productId,amount,isDelete) values (?,?,?,?)");
			ps.setString(1,od.getOrderId());
			ps.setInt(2,od.getProductId());
			ps.setInt(3,od.getAmount());
			ps.setInt(4,1);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}

}

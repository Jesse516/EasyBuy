package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.ProductDao;
import com.zjx.Entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao{
	Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	Product product = null;
	int result=0;
	public List<Product> showAllUserByPage(int pageNo, int pageSize) {
		List<Product> li = new ArrayList<Product>();
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select * from product limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("detail"),rs.getInt("cid"),rs.getDouble("price"),rs.getInt("amount"),rs.getString("src"));
				li.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	public int countPageByProduct() {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select count(id) from product");
			rs=ps.executeQuery();
			if(rs.next()){
				result= rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int addProduct(Product product) {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("insert into product (name,detail,cid,price,amount,src) values (?,?,?,?,?,?)");
			ps.setString(1, product.getName());
			ps.setString(2, product.getDetail());
			ps.setDouble(3,product.getCid());
			ps.setDouble(4,product.getPrice());
			ps.setInt(5,product.getAmount());
			ps.setString(6,product.getSrc());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Product findProductById(int id) {
		con = this.getConnection();
		try {
			ps=con.prepareStatement("select * from product where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("detail"),rs.getInt("cid"),rs.getDouble("price"),rs.getInt("amount"),rs.getString("src"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	public int updateProduct(Product product) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update product set name=?,detail=?,cid=?,price=?,amount=?,src=? where id=?");
			ps.setString(1, product.getName());
			ps.setString(2, product.getDetail());
			ps.setInt(3, product.getCid());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getAmount());
			ps.setString(6, product.getSrc());
			ps.setInt(7, product.getId());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int deleteProduct(int id) {
		con = this.getConnection();
		try {
			ps=con.prepareStatement("delete from product where id=?");
			ps.setInt(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Product> showAllProduct() {
		List<Product> li = new ArrayList<Product>();
		con = this.getConnection();
		try {
			ps=con.prepareStatement("select * from product limit 0,8;");
			rs=ps.executeQuery();
			while(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("detail"),rs.getInt("cid"),rs.getDouble("price"),rs.getInt("amount"),rs.getString("src"));
				li.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

}

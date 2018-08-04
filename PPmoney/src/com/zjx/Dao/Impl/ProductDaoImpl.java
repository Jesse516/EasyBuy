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
	Connection con = null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	Product product=null;
	int result=0;
	public List<Product> showAllInvestment() {
		List<Product> li = new ArrayList<Product>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from product where status=0");
			rs=ps.executeQuery();
			while(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("issueCompany"),rs.getInt("duration"),rs.getDouble("rate"),rs.getString("type"),rs.getDouble("money"),rs.getDouble("collectMoney"),rs.getInt("status"));
				li.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}
	
	public int countAllInvestment() {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select count(*) from product where status=0");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}
	
	public int countFullInvestment() {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select count(*) from product where status=0 and money=collectMoney");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}

	public List<Product> showAllInvestmentByPage(int pageNo,int pageSize) {
		List<Product> li = new ArrayList<Product>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from product where status=0 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("issueCompany"),rs.getInt("duration"),rs.getDouble("rate"),rs.getString("type"),rs.getDouble("money"),rs.getDouble("collectMoney"),rs.getInt("status"));
				li.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByInvestment() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from product where status=0");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}

	public List<Product> showAllLoan() {
		List<Product> li = new ArrayList<Product>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from product where status=1");
			rs=ps.executeQuery();
			while(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("issueCompany"),rs.getInt("duration"),rs.getDouble("rate"),rs.getString("type"),rs.getDouble("money"),rs.getDouble("collectMoney"),rs.getInt("status"));
				li.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}

	public int countAllLoan() {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select count(*) from product where status=1");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}

	public int countFullLoan() {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select count(*) from product where status=1 and money=collectMoney");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}

	public List<Product> showAllLoanByPage(int pageNo, int pageSize) {
		List<Product> li = new ArrayList<Product>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from product where status=1 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("issueCompany"),rs.getInt("duration"),rs.getDouble("rate"),rs.getString("type"),rs.getDouble("money"),rs.getDouble("collectMoney"),rs.getInt("status"));
				li.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByLoan() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from product where status=1");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}

	
}

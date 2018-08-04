package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.HtranDao;
import com.zjx.Entity.Htran;
import com.zjx.Entity.User;

public class HtranDaoImpl extends BaseDao implements HtranDao{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	Htran htran=null;
	
	public int countTodayHtran() {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(*) from htran where time=?");
			Date date = new Date(System.currentTimeMillis());
			ps.setString(1, date.toString());
			rs=ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Double todayMoney() {
		double result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select sum(money) from htran where time=?");
			Date date = new Date(System.currentTimeMillis());
			ps.setString(1, date.toString());
			rs=ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int countAllHtran() {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(*) from htran");
			rs=ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Double allMoney() {
		double result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select sum(money) from htran");
			Date date = new Date(System.currentTimeMillis());
			rs=ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Htran> showAllCHtranByPage(int pageNo, int pageSize) {
		List<Htran> li = new ArrayList<Htran>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("SELECT * FROM htran INNER JOIN product ON htran.productId=product.id WHERE product.money=product.collectMoney limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				htran = new Htran(rs.getInt("id"),rs.getInt("buyerId"),rs.getInt("type"),rs.getInt("productId"),rs.getDouble("money"),rs.getString("time"));
				li.add(htran);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByCHtran() {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("SELECT count(*) FROM htran INNER JOIN product ON htran.productId=product.id WHERE product.money=product.collectMoney");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Htran> showAllUHtranByPage(int pageNo, int pageSize) {
		List<Htran> li = new ArrayList<Htran>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("SELECT * FROM htran INNER JOIN product ON htran.productId=product.id WHERE product.money>product.collectMoney limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				htran = new Htran(rs.getInt("id"),rs.getInt("buyerId"),rs.getInt("type"),rs.getInt("productId"),rs.getDouble("money"),rs.getString("time"));
				li.add(htran);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByUHtran() {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("SELECT count(*) FROM htran INNER JOIN product ON htran.productId=product.id WHERE product.money>product.collectMoney");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

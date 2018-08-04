package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.CasesDao;
import com.zjx.Entity.Cases;
import com.zjx.Entity.User;

public class CasesDaoImpl extends BaseDao implements CasesDao{
	Connection con =null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	Cases cases = null;
	public List<Cases> showAllCases() {
		List<Cases> li = new ArrayList<Cases>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from cases");
			rs=ps.executeQuery();
			while(rs.next()){
				cases = new Cases(rs.getInt("id"),rs.getString("pic"),rs.getString("time"),rs.getString("content"),rs.getString("src"));
				li.add(cases);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	public List<Cases> showAllCasesByPage(int pageNo, int pageSize) {
		List<Cases> li = new ArrayList<Cases>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from cases limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				cases = new Cases(rs.getInt("id"),rs.getString("pic"),rs.getString("time"),rs.getString("content"),rs.getString("src"));
				li.add(cases);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}
	public int countPageByCases() {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(*) from cases");
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

package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.NewsDao;
import com.zjx.Entity.News;
import com.zjx.Entity.User;

public class NewsDaoImpl extends BaseDao implements NewsDao{
	Connection con = null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	News news = null;
	
	public List<News> findAllNews(int type) {
		List<News> li = new ArrayList<News>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from news where `type`=?");
			ps.setInt(1, type);
			rs=ps.executeQuery();
			while(rs.next()){
				news = new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("time"),rs.getInt("type"));
				li.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	
	public List<News> findAllNews() {
		List<News> li = new ArrayList<News>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from news");
			rs=ps.executeQuery();
			while(rs.next()){
				news = new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("time"),rs.getInt("type"));
				li.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	public List<News> showAllNewsByPage(int pageNo, int pageSize) {
		List<News> li = new ArrayList<News>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from news limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				news =new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getString("time"),rs.getInt("type"));
				li.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByNews() {
		int result=0;
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from news");
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

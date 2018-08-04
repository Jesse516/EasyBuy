package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.zjx.Dao.BaseDao;

import com.zjx.Dao.NewsDao;
import com.zjx.Entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao{
	Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	int result=0;	
	News news = null;
	List<News> li = new ArrayList<News>();
	public int addNews(News news) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("insert into news(title,content,createTime) values (?,?,?)");
			ps.setString(1,news.getTitle());
			ps.setString(2,news.getContent());
			ps.setTimestamp(3,news.getCreateTime());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}
	
	
	public List<News> showNews() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from news");
			rs=ps.executeQuery();
			while(rs.next()){
				news = new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getTimestamp("createTime"));
				li.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}


	public int alterNews(News news) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update news set title=?,content=?,createTime=? where id=?");
			ps.setString(1,news.getTitle());
			ps.setString(2,news.getContent());
			ps.setTimestamp(3,news.getCreateTime());
			ps.setInt(4,news.getId());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}


	public int deleteNews(int id) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("delete from news where id=?");
			ps.setInt(1,id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}
	
	
	public List<News> showAllListByPage(int pageNo,int pageSize){
		List<News> li = new ArrayList<News>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from news limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				news = new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getTimestamp("createTime"));
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
	
	
	public int countPageByNews(){
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

	public News findNewsById(int id) {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select * from news where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				news = new News(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getTimestamp("createTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

}

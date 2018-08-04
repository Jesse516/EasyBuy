package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.CategoryDao;
import com.zjx.Entity.Category;

public class CategoryDaoImpl extends BaseDao implements CategoryDao{
	Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	int result=0;
	int i=1;
	Category category = null;
	public int countParentPage() {
		try {
			con = this.getConnection();
			ps = con.prepareStatement("select count(id) from category where pid=0;");
			rs=ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}
	
	public List<Category> parentList(int pageNo, int pageSize) {
		List<Category> li = new ArrayList<Category>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from category where pid=0 limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				category = new Category(rs.getInt("id"),rs.getString("name"),rs.getInt("pid"));
				li.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}

	public List<Category> findChildByParent(int pid) {
		List<Category> li = new ArrayList<Category>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from category where pid=?");
			ps.setInt(1, pid);
			rs=ps.executeQuery();
			while(rs.next()){
				category = new Category(rs.getInt("id"),rs.getString("name"),rs.getInt("pid"));
				li.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}

	public List<Category> findAllParentName() {
		List<Category> li = new ArrayList<Category>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from category where pid=0");
			rs=ps.executeQuery();
			while(rs.next()){
				category= new Category(rs.getInt("id"),rs.getString("name"),rs.getInt("pid"));
				li.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,rs);
		}
		return li;
	}

	public int addParentName(String name) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("insert into category (name,pid) values (?,0)");
			ps.setString(1,name);
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public Category findCategoryById(int id) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from category where id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				category = new Category(rs.getInt("id"),rs.getString("name"),rs.getInt("pid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,null);
		}
		return category;
	}

	public int updateCategory(int id,String name) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update category set name=? where id=?");
			ps.setString(1,name);
			ps.setInt(2,id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public int delCategory(int id) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("delete from category where id=?");
			ps.setInt(1,id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public int delBigCategory(int pid) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("delete from category where pid=?");
			ps.setInt(1,pid);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public Map<Integer,List<Category>> findEveryCategoryList(int id) {
		List<Category> li = new ArrayList<Category>();
		Map<Integer,List<Category>> map  = new LinkedHashMap<Integer,List<Category>>();
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from category where pid=?");				
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				category = new Category(rs.getInt("id"),rs.getString("name"),rs.getInt("pid"));
				li.add(category);
			}
			map.put(i++, li);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public int countCategoryNum(int id){
		List<Category> li = new ArrayList<Category>();
		Map<Integer,List<Category>> map  = new LinkedHashMap<Integer,List<Category>>();
		li=map.get(i);
		for(int i=0;i<li.size();i++){
			findEveryCategoryList(li.get(i).getId());
			
		}
		
		return id;
	}

	public int addChildName(int id, String name) {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("insert into category (name,pid) values (?,?)");
			ps.setString(1,name);
			ps.setInt(2,id);
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

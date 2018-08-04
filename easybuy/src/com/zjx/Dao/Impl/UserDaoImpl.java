package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.UserDao;
import com.zjx.Entity.News;
import com.zjx.Entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	int result=0;
	User user=null;
	List<User> li = new ArrayList<User>();
	public int addUser(User user) {
		con= this.getConnection();
		try {
			ps =con.prepareStatement("insert into user values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSex());
			ps.setDate(5, user.getBirthday());
			ps.setString(6, user.getIdentity());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getMobile());
			ps.setString(9, user.getAddress());
			ps.setInt(10, user.getType());
			ps.setInt(11,user.getStatus());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		
		return result;
	}
	
	public User findCertainUser(String id,String password) {
		con = this.getConnection();
		try {
			ps=con.prepareStatement("select * from user where id=? and password=? and status=1");
			ps.setString(1, id);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"),rs.getString("sex"),rs.getDate("birthday"),rs.getString("identity"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"),rs.getInt("type"),rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return user;
	}

	public int deleteUser(String id) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update user set status=0 where id=?");
			ps.setString(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public List<User> showAllUser() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from user where status<>0");
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"),rs.getString("sex"),rs.getDate("birthday"),rs.getString("identity"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"),rs.getInt("type"),rs.getInt("status"));
				li.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return li;
	}

	public User findById(String id) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from user where id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"),rs.getString("sex"),rs.getDate("birthday"),rs.getString("identity"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"),rs.getInt("type"),rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return user;
	}

	public int updateUserById(User user) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update user set name=?,password=?,sex=?,birthday=?,mobile=?,address=? where id=?");
			ps.setString(1,user.getName());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getSex());
			ps.setObject(4,user.getBirthday());
			ps.setString(5, user.getMobile());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getId());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public int ajaxLoginByName(String id) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from user where id=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				result=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public String ajaxLoginByPassword(String id) {
		String password="";
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select password from user where id=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				password=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con,ps,null);
		}
		return password;
	}

	public List<User> showAllManagerByPage(int pageNo, int pageSize) {
		List<User> li = new ArrayList<User>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from user where type=0 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"),rs.getString("sex"),rs.getDate("birthday"),rs.getString("identity"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"),rs.getInt("type"),rs.getInt("status"));
				li.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}
	
	public List<User> showAllUserByPage(int pageNo, int pageSize) {
		List<User> li = new ArrayList<User>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from user where type=1 and status=1 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"),rs.getString("sex"),rs.getDate("birthday"),rs.getString("identity"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"),rs.getInt("type"),rs.getInt("status"));
				li.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}
	
	public List<User> showAllLogoutByPage(int pageNo, int pageSize) {
		List<User> li = new ArrayList<User>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from user where type=1 and status=0 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"),rs.getString("sex"),rs.getDate("birthday"),rs.getString("identity"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"),rs.getInt("type"),rs.getInt("status"));
				li.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByUser() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from user where type=1 and status=1");
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

	public int countPageByManager() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from user where type=0");
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

	public int countPageByLogout() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from user where type=1 and status=0");
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

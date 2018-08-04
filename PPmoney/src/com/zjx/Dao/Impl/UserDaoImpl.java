package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.UserDao;
import com.zjx.Entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	int result=0;
	User user=null;
	public int inputUserInfo(User user) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("insert into `user`(surName,card,phone,password,birthday,email,occupation,joinTime,type,status) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getSurName());
			ps.setString(2, user.getCard());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getBirthday());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getOccupation());
			ps.setString(8, user.getJoinTime());
			ps.setInt(9, user.getType());
			ps.setInt(10, user.getStatus());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public User forgetPassword(String surName, String phone, String birthday,
			String email) {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("select * from user where surName=? and phone=? and birthday=? and email=?");
			ps.setString(1, surName);
			ps.setString(2, phone);
			ps.setString(3, birthday);
			ps.setString(4, email);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("surName"),rs.getString("card"),rs.getString("phone"),rs.getString("password"),rs.getString("birthday"),rs.getString("email"),rs.getString("occupation"),rs.getString("joinTime"),rs.getInt("type"),rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public int updatePassword(int id, String password) {
		con = this.getConnection();
		try {
			ps =con.prepareStatement("update user set password=? where id=?");
			ps.setString(1, password);
			ps.setInt(2, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public User loginByPhoneAndPassword(String phone, String password) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from user where phone=? and password=?");
			ps.setString(1, phone);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("surName"),rs.getString("card"),rs.getString("phone"),rs.getString("password"),rs.getString("birthday"),rs.getString("email"),rs.getString("occupation"),rs.getString("joinTime"),rs.getInt("type"),rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public int insertCard(String phone, String cardNo) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update user set card=? where phone=?");
			ps.setString(1, cardNo);
			ps.setString(2, phone);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int countAllUser() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(*) from user");
			rs=ps.executeQuery();
			while(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int countBindUser() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(*) from user where card!=''");
			rs=ps.executeQuery();
			while(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<User> showAllManagerByPage(int pageNo, int pageSize) {
		List<User> li = new ArrayList<User>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from user where type=1 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("surName"),rs.getString("card"),rs.getString("phone"),rs.getString("password"),rs.getString("birthday"),rs.getString("email"),rs.getString("occupation"),rs.getString("joinTime"),rs.getInt("type"),rs.getInt("status"));
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
			ps= con.prepareStatement("select * from user where type=0 and status=0 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("surName"),rs.getString("card"),rs.getString("phone"),rs.getString("password"),rs.getString("birthday"),rs.getString("email"),rs.getString("occupation"),rs.getString("joinTime"),rs.getInt("type"),rs.getInt("status"));
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
			ps= con.prepareStatement("select * from user where type=0 and status=1 limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("surName"),rs.getString("card"),rs.getString("phone"),rs.getString("password"),rs.getString("birthday"),rs.getString("email"),rs.getString("occupation"),rs.getString("joinTime"),rs.getInt("type"),rs.getInt("status"));
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
			ps = con.prepareStatement("select count(id) from user where type=0 and status=0");
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
			ps = con.prepareStatement("select count(id) from user where type=1");
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
			ps = con.prepareStatement("select count(id) from user where type=0 and status=1");
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

	public int addUserInfo(User user) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("update user set surName=?,birthday=?,email=?,occupation=? where id=?");
			ps.setString(1, user.getSurName());
			ps.setString(2, user.getBirthday());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getOccupation());
			ps.setInt(5, user.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

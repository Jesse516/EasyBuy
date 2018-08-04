package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.User;

public interface UserDao {
	public int addUser(User user);
	public User findCertainUser(String id,String password);
	public int deleteUser(String id);
	public List<User> showAllUser();
	public User findById(String id);
	public int updateUserById(User user);
	public int ajaxLoginByName(String id);
	public String ajaxLoginByPassword(String id);
	public List<User> showAllManagerByPage(int pageNo,int pageSize);
	public int countPageByManager();
	public List<User> showAllUserByPage(int pageNo,int pageSize);
	public int countPageByUser();
	public List<User> showAllLogoutByPage(int pageNo,int pageSize);
	public int countPageByLogout();
	
}

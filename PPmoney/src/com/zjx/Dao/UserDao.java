package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.User;

public interface UserDao {
	public int inputUserInfo(User user);
	public User forgetPassword(String surName,String phone,String birthday,String email);
	public int updatePassword(int id,String password);
	public User loginByPhoneAndPassword(String phone,String password);
	public int insertCard(String phone,String cardNo);
	
	public int countAllUser();
	public int countBindUser();
	
	public List<User> showAllManagerByPage(int pageNo,int pageSize);
	public int countPageByManager();
	public List<User> showAllUserByPage(int pageNo,int pageSize);
	public int countPageByUser();
	public List<User> showAllLogoutByPage(int pageNo,int pageSize);
	public int countPageByLogout();
	
	public int addUserInfo(User user);
	
}

package com.zjx.Service;

import java.util.List;

import com.zjx.Entity.User;

public interface UserService {
	public int inputUserInfo(User user);
	public User forgetPassword(String surName, String phone, String birthday,String email);
	public int updatePassword(int id, String password);
	public User loginByPhoneAndPassword(String phone, String password);
	public int insertCard(String phone, String cardNo);
	
	public int countAllUser();
	public int countBindUser();
	
	public List<User> showAllManagerByPage(int pageNo,int pageSize);
	public int countPageByManager(int pageSize);
	public List<User> showAllUserByPage(int pageNo,int pageSize);
	public int countPageByUser(int pageSize);
	public List<User> showAllLogoutByPage(int pageNo,int pageSize);
	public int countPageByLogout(int pageSize);
	
	public int addUserInfo(User user);
}

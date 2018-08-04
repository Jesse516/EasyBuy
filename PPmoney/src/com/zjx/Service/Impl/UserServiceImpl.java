package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.UserDaoImpl;
import com.zjx.Entity.User;
import com.zjx.Service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl udi = new UserDaoImpl();
	public int inputUserInfo(User user) {
		return udi.inputUserInfo(user);
	}
	public User forgetPassword(String surName, String phone, String birthday,
			String email) {
		return udi.forgetPassword(surName, phone, birthday, email);
	}
	public int updatePassword(int id, String password) {
		return udi.updatePassword(id, password);
	}
	public User loginByPhoneAndPassword(String phone, String password) {
		return udi.loginByPhoneAndPassword(phone, password);
	}
	public int insertCard(String phone, String cardNo) {
		return udi.insertCard(phone, cardNo);
	}
	public int countAllUser() {
		return udi.countAllUser();
	}
	public int countBindUser() {
		return udi.countBindUser();
	}
	public List<User> showAllManagerByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return udi.showAllManagerByPage(pageNo, pageSize);
	}
	public List<User> showAllUserByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return udi.showAllUserByPage(pageNo, pageSize);
	}
	public List<User> showAllLogoutByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return udi.showAllLogoutByPage(pageNo, pageSize);
	}
	public int countPageByUser(int pageSize) {
		int result=0;
		if(udi.countPageByUser()%pageSize==0){
			result=udi.countPageByUser()/pageSize;
		}else{
			result=udi.countPageByUser()/pageSize+1;
		}
		return result;
	}
	public int countPageByManager(int pageSize) {
		int result=0;
		if(udi.countPageByManager()%pageSize==0){
			result=udi.countPageByManager()/pageSize;
		}else{
			result=udi.countPageByManager()/pageSize+1;
		}
		return result;
	}
	public int countPageByLogout(int pageSize) {
		int result=0;
		if(udi.countPageByLogout()%pageSize==0){
			result=udi.countPageByLogout()/pageSize;
		}else{
			result=udi.countPageByLogout()/pageSize+1;
		}
		return result;
	}

	public int addUserInfo(User user){
		return udi.addUserInfo(user);
	}
}

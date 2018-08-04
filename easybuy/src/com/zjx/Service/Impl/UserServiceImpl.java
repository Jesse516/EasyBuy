package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.UserDaoImpl;
import com.zjx.Entity.User;
import com.zjx.Service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl udi = new UserDaoImpl();
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return udi.addUser(user);
	}
	public User findCertainUser(String id,String password) {
		// TODO Auto-generated method stub
		return udi.findCertainUser(id,password);
	}
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return udi.deleteUser(id);
	}
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		return udi.showAllUser();
	}
	public User findById(String id) {
		// TODO Auto-generated method stub
		return udi.findById(id);
	}
	public int updateUserById(User user) {
		// TODO Auto-generated method stub
		return udi.updateUserById(user);
	}
	public int ajaxLoginByName(String id) {
		// TODO Auto-generated method stub
		return udi.ajaxLoginByName(id);
	}
	public String ajaxLoginByPassword(String id) {
		// TODO Auto-generated method stub
		return udi.ajaxLoginByPassword(id);
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

}

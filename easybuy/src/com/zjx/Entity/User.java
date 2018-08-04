package com.zjx.Entity;

import java.sql.Date;


public class User {
	private String id;
	private String name;
	private String password;
	private String sex;
	private Date birthday;
	private String identity;
	private String email;
	private String mobile;
	private String address;
	private Integer type;
	private Integer status;
	public User(String id, String name, String password, String sex,
			Date date, String identity, String email, String mobile,
			String address, Integer type, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = date;
		this.identity = identity;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.type = type;
		this.status = status;
	}
	public User(String name, String password, String sex, Date birthday,
			String identity, String email, String mobile, String address,
			Integer type, Integer status) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.type = type;
		this.status = status;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

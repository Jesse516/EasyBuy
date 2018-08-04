package com.zjx.Entity;

public class User {
	private Integer id;
	private String surName;
	private String card;
	private String phone;
	private String password;
	private String birthday;
	private String email;
	private String occupation;
	private String joinTime;
	private Integer type;
	private Integer status;
	public User(Integer id, String surName, String card, String phone,
			String password, String birthday, String email, String occupation,
			String joinTime, Integer type, Integer status) {
		super();
		this.id = id;
		this.surName = surName;
		this.card = card;
		this.phone = phone;
		this.password = password;
		this.birthday = birthday;
		this.email = email;
		this.occupation = occupation;
		this.joinTime = joinTime;
		this.type = type;
		this.status = status;
	}
	public User(String surName, String card, String phone, String password,
			String birthday, String email, String occupation, String joinTime,
			Integer type, Integer status) {
		super();
		this.surName = surName;
		this.card = card;
		this.phone = phone;
		this.password = password;
		this.birthday = birthday;
		this.email = email;
		this.occupation = occupation;
		this.joinTime = joinTime;
		this.type = type;
		this.status = status;
	}
	public User() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
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

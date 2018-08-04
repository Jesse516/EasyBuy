package com.zjx.Entity;

import java.io.Serializable;

public class Category implements Serializable{
	private Integer id;
	private String name;
	private Integer pid;
	public Category(Integer id, String name, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	public Category(String name, Integer pid) {
		super();
		this.name = name;
		this.pid = pid;
	}
	public Category() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
}

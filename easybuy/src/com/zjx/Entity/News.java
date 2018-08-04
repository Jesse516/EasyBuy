package com.zjx.Entity;

import java.sql.Date;
import java.sql.Timestamp;



public class News {
	private Integer id;
	private String title;
	private String content;
	private Timestamp createTime;
	public News(Integer id, String title, String content, Timestamp createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	public News(String title, String content, Timestamp createTime) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	public News() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}

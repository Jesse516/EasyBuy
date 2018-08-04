package com.zjx.Entity;

import java.sql.Date;

public class News {
	private Integer id;
	private String title;
	private String content;
	private String time;
	private Integer type;
	public News(Integer id, String title, String content, String time,
			Integer type) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.type = type;
	}
	public News(String title, String content, String time, Integer type) {
		super();
		this.title = title;
		this.content = content;
		this.time = time;
		this.type = type;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}

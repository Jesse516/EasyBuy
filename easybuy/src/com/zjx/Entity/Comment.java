package com.zjx.Entity;

import java.sql.Timestamp;

public class Comment {
	private Integer id;
	private String content;
	private String createTime;
	private String reply;
	private String replyTime;
	private String name;
	public Comment(Integer id, String content, String createTime,
			String reply, String replyTime, String name) {
		super();
		this.id = id;
		this.content = content;
		this.createTime = createTime;
		this.reply = reply;
		this.replyTime = replyTime;
		this.name = name;
	}
	public Comment(String content, String createTime, String reply,
			String replyTime, String name) {
		super();
		this.content = content;
		this.createTime = createTime;
		this.reply = reply;
		this.replyTime = replyTime;
		this.name = name;
	}
	public Comment(String content, String createTime, String name) {
		super();
		this.content = content;
		this.createTime = createTime;
		this.name = name;
	}
	public Comment() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}

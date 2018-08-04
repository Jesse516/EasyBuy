package com.zjx.Entity;

public class Cases {
	private Integer id;
	private String pic;
	private String time;
	private String content;
	private String src;
	public Cases(Integer id, String pic, String time, String content, String src) {
		super();
		this.id = id;
		this.pic = pic;
		this.time = time;
		this.content = content;
		this.src = src;
	}
	public Cases(String pic, String time, String content, String src) {
		super();
		this.pic = pic;
		this.time = time;
		this.content = content;
		this.src = src;
	}
	public Cases() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
}

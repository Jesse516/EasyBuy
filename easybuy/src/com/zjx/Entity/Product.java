package com.zjx.Entity;

public class Product {
	private int id;
	private String name;
	private String detail;
	private int cid;
	private double price;
	private int amount;
	private String src;
	public Product(int id, String name, String detail, int cid, double price, int amount, String src) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.cid =cid;
		this.price = price;
		this.amount = amount;
		this.src = src;
	}
	public Product(String name, String detail, int cid, double price, int amount, String src) {
		super();
		this.name = name;
		this.detail = detail;
		this.cid =cid;
		this.price = price;
		this.amount = amount;
		this.src = src;
	}
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
}

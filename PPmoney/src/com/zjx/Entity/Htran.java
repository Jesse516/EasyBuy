package com.zjx.Entity;

import java.sql.Timestamp;

public class Htran {
	private Integer id;
	private Integer buyerId;
	private Integer type;
	private Integer productId;
	private Double money;
	private String time;
	public Htran(Integer id, Integer buyerId, Integer type, Integer productId,
			Double money, String time) {
		super();
		this.id = id;
		this.buyerId = buyerId;
		this.type = type;
		this.productId = productId;
		this.money = money;
		this.time = time;
	}
	public Htran(Integer buyerId, Integer type, Integer productId,
			Double money, String time) {
		super();
		this.buyerId = buyerId;
		this.type = type;
		this.productId = productId;
		this.money = money;
		this.time = time;
	}
	public Htran() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}

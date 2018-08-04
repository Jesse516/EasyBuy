package com.zjx.Entity;

import java.sql.Timestamp;

public class Order {
	private String orderId;
	private String userId;
	private Timestamp createTime;
	private Integer status;
	private Integer isDelete;
	private Double cost;
	public Order(String orderId, String userId, Timestamp createTime,
			Integer status, Integer isDelete, Double cost) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.createTime = createTime;
		this.status = status;
		this.isDelete = isDelete;
		this.cost = cost;
	}
	public Order(String orderId, String userId, Timestamp createTime,
			Integer status, Integer isDelete) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.createTime = createTime;
		this.status = status;
		this.isDelete = isDelete;
	}

	public Order() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}

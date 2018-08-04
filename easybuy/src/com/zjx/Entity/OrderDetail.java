package com.zjx.Entity;

public class OrderDetail {
	private Integer id;
	private String orderId;
 	private Integer productId;
	private Integer amount;
	private Integer isDelete;
	private String name;
	private String src;
	private Double price;
	private Double total;
	
	public OrderDetail(Integer id, String orderId, Integer productId,
			Integer amount, Integer isDelete, String name, String src,
			Double price,Double total) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.isDelete = isDelete;
		this.name = name;
		this.src = src;
		this.price = price;
		this.total = total;
	}
	public OrderDetail(Integer id, String orderId, Integer productId,
			Integer amount, Integer isDelete, String name, String src,
			Double price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.isDelete = isDelete;
		this.name = name;
		this.src = src;
		this.price = price;
	}
	public OrderDetail(Integer id, String orderId, Integer productId,
			Integer amount, Integer isDelete) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.isDelete = isDelete;
	}
	public OrderDetail(String orderId, Integer productId, Integer amount,
			Integer isDelete) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.isDelete = isDelete;
	}
	public OrderDetail() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotal() {
		total=price*amount;
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	 
}

package com.zjx.Entity;

public class CardPhone {
	private Integer id;
	private String cardNo;
	private String phone;
	public CardPhone(Integer id, String cardNo, String phone) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.phone = phone;
	}
	public CardPhone(String cardNo, String phone) {
		super();
		this.cardNo = cardNo;
		this.phone = phone;
	}
	public CardPhone() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

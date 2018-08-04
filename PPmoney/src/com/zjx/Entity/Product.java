package com.zjx.Entity;

public class Product {
	private Integer id;
	private String name;
	private String issueCompany;
	private Integer duration;
	private Double rate;
	private String type;
	private Double money;
	private Double collectMoney;
	private Integer status;
	public Product(Integer id, String name, String issueCompany, Integer duration,
			Double rate, String type, Double money, Double collectMoney,
			Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.issueCompany = issueCompany;
		this.duration = duration;
		this.rate = rate;
		this.type = type;
		this.money = money;
		this.collectMoney = collectMoney;
		this.status = status;
	}
	public Product(String name, String issueCompany, Integer duration,
			Double rate, String type, Double money, Double collectMoney,
			Integer status) {
		super();
		this.name = name;
		this.issueCompany = issueCompany;
		this.duration = duration;
		this.rate = rate;
		this.type = type;
		this.money = money;
		this.collectMoney = collectMoney;
		this.status = status;
	}
	public Product() {
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
	public String getIssueCompany() {
		return issueCompany;
	}
	public void setIssueCompany(String issueCompany) {
		this.issueCompany = issueCompany;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getCollectMoney() {
		return collectMoney;
	}
	public void setCollectMoney(Double collectMoney) {
		this.collectMoney = collectMoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

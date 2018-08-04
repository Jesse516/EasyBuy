package com.zjx.Entity;

public class SaleLine {
	private Product product;
	private Integer num=1;
	private Double sum;
	public SaleLine(Product product, Integer num, Double sum) {
		super();
		this.product = product;
		this.num = num;
		this.sum = sum;
	}
	public SaleLine() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getSum() {
		sum=product.getPrice()*num;
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	
}

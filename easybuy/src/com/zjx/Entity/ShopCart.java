package com.zjx.Entity;

import java.util.LinkedList;
import java.util.List;

public class ShopCart {
	private List<SaleLine> lines = new LinkedList<SaleLine>();
	private Double total;
	public ShopCart(List<SaleLine> lines, Double total) {
		super();
		this.lines = lines;
		this.total = total;
	}
	public ShopCart() {
		super();
	}
	public List<SaleLine> getLines() {
		return lines;
	}
	public void setLines(List<SaleLine> lines) {
		this.lines = lines;
	}
	public Double getTotal() {
		double sum=0;
		for(SaleLine sl:lines){
			sum+=sl.getSum();
		}
		total=sum;
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void add(SaleLine sl) {
		// TODO Auto-generated method stub\
		for(SaleLine line:lines){
			if(line.getProduct().getId()==sl.getProduct().getId()){
				line.setNum(line.getNum()+1);
				return;
			}
		}
		lines.add(sl);
	}
	public void delete(int id){
		for(SaleLine line:lines){
			if(line.getProduct().getId()==id){
				lines.remove(line);
				return;
			}
		}
	}
	public void clear(){
		lines.clear();
	}
	public void update(int id,int num){
		for(SaleLine line:lines){
			if(line.getProduct().getId()==id){
				line.setNum(num);
				return;
			}
		}
	}
}

package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.Product;

public interface ProductDao {
	public List<Product> showAllInvestment();
	public int countAllInvestment();
	public int countFullInvestment();
	public List<Product> showAllInvestmentByPage(int pageNo,int pageSize);
	public int countPageByInvestment();
	
	public List<Product> showAllLoan();
	public int countAllLoan();
	public int countFullLoan();
	public List<Product> showAllLoanByPage(int pageNo,int pageSize);
	public int countPageByLoan();
}

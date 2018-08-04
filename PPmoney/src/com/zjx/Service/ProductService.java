package com.zjx.Service;

import java.util.List;
import com.zjx.Entity.Product;

public interface ProductService {
	public List<Product> showAllInvestment();
	public int countAllInvestment();
	public int countFullInvestment();
	public List<Product> showAllInvestmentByPage(int pageNo,int pageSize);
	public int countPageByInvestment(int pageSize);
	
	public List<Product> showAllLoan();
	public int countAllLoan();
	public int countFullLoan();
	public List<Product> showAllLoanByPage(int pageNo,int pageSize);
	public int countPageByLoan(int pageSize);

}

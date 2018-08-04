package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.ProductDaoImpl;
import com.zjx.Entity.Product;
import com.zjx.Service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDaoImpl pdi = new ProductDaoImpl();
	public List<Product> showAllInvestment() {
		return pdi.showAllInvestment();
	}

	public int countAllInvestment() {
		return pdi.countAllInvestment();
	}

	public int countFullInvestment() {
		return pdi.countFullInvestment();
	}

	public List<Product> showAllInvestmentByPage(int pageNo, int pageSize) {
		return pdi.showAllInvestmentByPage(pageNo, pageSize);
	}

	public int countPageByInvestment(int pageSize) {
		int result=0;
		if(pdi.countPageByInvestment()%pageSize==0){
			result=pdi.countPageByInvestment()/pageSize;
		}else{
			result=pdi.countPageByInvestment()/pageSize+1;
		}
		return result;
	}

	public List<Product> showAllLoan() {
		return pdi.showAllLoan();
	}

	public int countAllLoan() {
		return pdi.countAllLoan();
	}

	public int countFullLoan() {
		return pdi.countFullLoan();
	}

	public List<Product> showAllLoanByPage(int pageNo, int pageSize) {
		return pdi.showAllLoanByPage(pageNo, pageSize);
	}

	public int countPageByLoan(int pageSize) {
		int result=0;
		if(pdi.countPageByLoan()%pageSize==0){
			result=pdi.countPageByLoan()/pageSize;
		}else{
			result=pdi.countPageByLoan()/pageSize+1;
		}
		return result;
	}
	

}

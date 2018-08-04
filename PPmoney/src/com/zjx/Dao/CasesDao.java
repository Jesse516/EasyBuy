package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.Cases;

public interface CasesDao {
	public List<Cases> showAllCases();
	
	public List<Cases> showAllCasesByPage(int pageNo,int pageSize);
	public int countPageByCases();
}

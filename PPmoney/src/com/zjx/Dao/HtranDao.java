package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.Htran;

public interface HtranDao {
	public int countTodayHtran();
	public Double todayMoney();
	
	public int countAllHtran();
	public Double allMoney();
	
	public List<Htran> showAllCHtranByPage(int pageNo,int pageSize);
	public int countPageByCHtran();
	public List<Htran> showAllUHtranByPage(int pageNo,int pageSize);
	public int countPageByUHtran();
}

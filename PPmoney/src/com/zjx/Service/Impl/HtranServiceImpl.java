package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.HtranDaoImpl;
import com.zjx.Entity.Htran;
import com.zjx.Service.HtranService;

public class HtranServiceImpl implements HtranService{
	HtranDaoImpl hdi = new HtranDaoImpl();
	public int countTodayHtran() {
		// TODO Auto-generated method stub
		return hdi.countTodayHtran();
	}

	public Double todayMoney() {
		// TODO Auto-generated method stub
		return hdi.todayMoney();
	}

	public int countAllHtran() {
		// TODO Auto-generated method stub
		return hdi.countAllHtran();
	}

	public Double allMoney() {
		// TODO Auto-generated method stub
		return hdi.allMoney();
	}

	public List<Htran> showAllCHtranByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return hdi.showAllCHtranByPage(pageNo, pageSize);
	}

	public int countPageByCHtran(int pageSize) {
		int result=0;
		if(hdi.countPageByCHtran()%pageSize==0){
			result=hdi.countPageByCHtran()/pageSize;
		}else{
			result=hdi.countPageByCHtran()/pageSize+1;
		}
		return result;
	}

	public List<Htran> showAllUHtranByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return hdi.showAllUHtranByPage(pageNo, pageSize);
	}

	public int countPageByUHtran(int pageSize) {
		int result=0;
		if(hdi.countPageByUHtran()%pageSize==0){
			result=hdi.countPageByUHtran()/pageSize;
		}else{
			result=hdi.countPageByUHtran()/pageSize+1;
		}
		return result;
	}

}

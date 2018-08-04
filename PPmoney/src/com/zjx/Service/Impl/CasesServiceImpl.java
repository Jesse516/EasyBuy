package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.CasesDaoImpl;
import com.zjx.Entity.Cases;
import com.zjx.Service.CasesService;

public class CasesServiceImpl implements CasesService{
	CasesDaoImpl cdi = new CasesDaoImpl();
	public List<Cases> showAllCases() {
		// TODO Auto-generated method stub
		return cdi.showAllCases();
	}
	public List<Cases> showAllCasesByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cdi.showAllCasesByPage(pageNo, pageSize);
	}
	public int countPageByCases(int pageSize) {
		int result=0;
		if(cdi.countPageByCases()%pageSize==0){
			result=cdi.countPageByCases()/pageSize;
		}else{
			result=cdi.countPageByCases()/pageSize+1;
		}
		return result;
	}

}

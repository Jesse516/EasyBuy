package com.zjx.Service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.zjx.Dao.Impl.CategoryDaoImpl;
import com.zjx.Entity.Category;
import com.zjx.Service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	CategoryDaoImpl cdi = new CategoryDaoImpl();
	Map<Integer,List<Category>> map = new LinkedHashMap<Integer,List<Category>>();
	int result=0;
	public int countParentPage(int pageSize) {
		if(cdi.countParentPage()%pageSize==0){
			result=cdi.countParentPage()/pageSize;
		}else{
			result=cdi.countParentPage()/pageSize+1;
		}
		return result;
	}
 	
	public Map<Category,List<Category>> parentList(int pageNo, int pageSize) {
		List<Category> pli = new ArrayList<Category>();
		pli=cdi.parentList(pageNo, pageSize);
		List<Category> cli = new ArrayList<Category>();
		Map<Category,List<Category>> map = new LinkedHashMap<Category,List<Category>>();
		for(Category p:pli){
			cli=cdi.findChildByParent(p.getId());
			map.put(p, cli);
		}
		return map;
	}

	public List<Category> findChildByParent(int pid) {
		return cdi.findChildByParent(pid);
	}

	public List<Category> findAllParentName() {
		return cdi.findAllParentName();
	}

	public int addParentName(String name) {
		return cdi.addParentName(name);
	}

	public Category findCategoryById(int id) {
		return cdi.findCategoryById(id);
	}

	public int updateCategory(int id,String name) {
		return cdi.updateCategory(id,name);
	}

	public int delCategory(int id) {
		return cdi.delCategory(id);
	}

	public int delBigCategory(int pid) {
		return cdi.delBigCategory(pid);
	}

	public Integer findCategoryLayer(int pid) {
		List<Category> li = new ArrayList<Category>();
		li=cdi.findChildByParent(pid);
		int sum=1;
		if(li!=null){
			for(int i=0;i<li.size();i++){
				pid = li.get(i).getId();
				findCategoryLayer(pid);
			}
			sum++;
		}
		return sum;
	}

	public int addChildName(int id, String name) {
		return cdi.addChildName(id, name);
	}
	

}

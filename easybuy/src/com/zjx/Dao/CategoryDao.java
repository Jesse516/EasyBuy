package com.zjx.Dao;

import java.util.List;
import java.util.Map;

import com.zjx.Entity.Category;

public interface CategoryDao {
	public int countParentPage();
	public List<Category> parentList(int pageNo,int pageSize);
	public List<Category> findChildByParent(int pid);
	public List<Category> findAllParentName();
	public int addParentName(String name);
	public Category findCategoryById(int id);
	public int updateCategory(int id,String name);
	public int delCategory(int id);
	public int delBigCategory(int id);
	public Map<Integer,List<Category>> findEveryCategoryList(int id);
	public int countCategoryNum(int id);
	public int addChildName(int id,String name);
}

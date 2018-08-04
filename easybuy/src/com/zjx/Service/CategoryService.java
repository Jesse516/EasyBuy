package com.zjx.Service;

import java.util.List;
import java.util.Map;

import com.zjx.Entity.Category;

public interface CategoryService {
	public int countParentPage(int pageSize);
	public Map<Category,List<Category>> parentList(int pageNo,int pageSize); 
	public List<Category> findChildByParent(int pid);
	public List<Category> findAllParentName();
	public int addParentName(String name);
	public Category findCategoryById(int id);
	public int updateCategory(int id,String name);
	public int delCategory(int id);
	public int delBigCategory(int pid);
	public Integer findCategoryLayer(int pid);
	public int addChildName(int id, String name);
}

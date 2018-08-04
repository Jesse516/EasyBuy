package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.News;
import com.zjx.Entity.User;

public interface NewsDao {
	public List<News> findAllNews(int id);
	public List<News> findAllNews();
	
	public List<News> showAllNewsByPage(int pageNo,int pageSize);
	public int countPageByNews();
}

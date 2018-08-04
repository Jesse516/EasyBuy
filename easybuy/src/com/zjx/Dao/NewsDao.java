package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.News;

public interface NewsDao {
	public int addNews(News news);
	public List<News> showNews();
	public int alterNews(News news);
	public int deleteNews(int id);
	public List<News> showAllListByPage(int pageNo,int pageSize);
	public int countPageByNews();
	public News findNewsById(int id);
	
}

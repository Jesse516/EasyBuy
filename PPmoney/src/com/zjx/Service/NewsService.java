package com.zjx.Service;

import java.util.List;

import com.zjx.Entity.News;
import com.zjx.Entity.User;

public interface NewsService {
	public List<News> findAllNews(int id);
	public List<News> findAllNews();
	
	public List<News> showAllNewsPage(int pageNo,int pageSize);
	public int countPageByNews(int pageSize);
}

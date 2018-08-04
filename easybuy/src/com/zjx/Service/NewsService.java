package com.zjx.Service;

import java.util.List;
import java.util.Map;

import com.zjx.Entity.News;

public interface NewsService {
	public int addNews(News news);
	public List<News> showNews();
	public int alterNews(News news);
	public int deleteNews(int id);
	public int countPageByNews(int pageSize);
	public List<News> showAllListByPage(int pageNo,int pageSize);
	public News findNewsById(int id);
}

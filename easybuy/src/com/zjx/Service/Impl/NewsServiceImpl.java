package com.zjx.Service.Impl;

import java.util.List;
import java.util.Map;

import com.zjx.Dao.Impl.NewsDaoImpl;
import com.zjx.Entity.News;
import com.zjx.Service.NewsService;

public class NewsServiceImpl implements NewsService{
	NewsDaoImpl ndi = new NewsDaoImpl();
	public int addNews(News news) {
		return ndi.addNews(news);
	}
	public List<News> showNews() {
		return ndi.showNews();
	}
	public int alterNews(News news) {
		return ndi.alterNews(news);
	}
	public int deleteNews(int id) {
		return ndi.deleteNews(id);
	}
	
	public int countPageByNews(int pageSize) {
		int result=0;
		if(ndi.countPageByNews()%pageSize==0){
			result=ndi.countPageByNews()/pageSize;
		}else{
			result=ndi.countPageByNews()/pageSize+1;
		}
		return result;
	}
	
	public List<News> showAllListByPage(int pageNo, int pageSize) {
		return ndi.showAllListByPage(pageNo, pageSize);
	}
	public News findNewsById(int id) {
		// TODO Auto-generated method stub
		return ndi.findNewsById(id);
	}

}

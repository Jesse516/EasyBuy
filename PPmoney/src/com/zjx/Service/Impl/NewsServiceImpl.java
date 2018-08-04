package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.NewsDaoImpl;
import com.zjx.Entity.News;
import com.zjx.Service.NewsService;

public class NewsServiceImpl implements NewsService{
	NewsDaoImpl ndi = new NewsDaoImpl();
	public List<News> findAllNews(int id) {
		return ndi.findAllNews(id);
	}
	
	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return ndi.findAllNews();
	}

	public List<News> showAllNewsPage(int pageNo, int pageSize) {
		return ndi.showAllNewsByPage(pageNo, pageSize);
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

}

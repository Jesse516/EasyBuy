package com.zjx.Service.Impl;

import java.util.List;

import com.zjx.Dao.Impl.CommentDaoImpl;
import com.zjx.Entity.Comment;
import com.zjx.Service.CommentService;

public class CommentServiceImpl implements CommentService{
	CommentDaoImpl cdi = new CommentDaoImpl();
	public List<Comment> showComment() {
		// TODO Auto-generated method stub
		return cdi.showComment();
	}
	
	public Comment findComment(int id) {
		// TODO Auto-generated method stub
		return cdi.findComment(id);
	}

	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return cdi.updateComment(comment);
	}

	public int deleteComment(int id) {
		// TODO Auto-generated method stub
		return cdi.deleteComment(id);
	}

	public List<Comment> showAllCommentByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cdi.showAllCommentByPage(pageNo, pageSize);
	}

	public int countPageByComment(int pageSize) {
		int result=0;
		if(cdi.countPageByComment()%pageSize==0){
			result=cdi.countPageByComment()/pageSize;
		}else{
			result=cdi.countPageByComment()/pageSize+1;
		}
		return result;
	}

	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return cdi.addComment(comment);
	}
	
}

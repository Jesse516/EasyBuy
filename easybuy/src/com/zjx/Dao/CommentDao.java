package com.zjx.Dao;

import java.util.List;

import com.zjx.Entity.Comment;

public interface CommentDao {
	public List<Comment> showComment();
	public Comment findComment(int id);
	public int updateComment(Comment comment);
	public int deleteComment(int id);
	public List<Comment> showAllCommentByPage(int pageNo,int pageSize);
	public int countPageByComment();
	public int addComment(Comment comment);
 
}

package com.zjx.Service;

import java.util.List;

import com.zjx.Entity.Comment;

public interface CommentService {
	public List<Comment> showComment();
	public Comment findComment(int id);
	public int updateComment(Comment comment);
	public int deleteComment(int id);
	public List<Comment> showAllCommentByPage(int pageNo, int pageSize);
	public int countPageByComment(int pageSize);
	public int addComment(Comment comment);
}

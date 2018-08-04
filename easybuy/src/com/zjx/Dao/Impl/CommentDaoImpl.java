package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.CommentDao;
import com.zjx.Entity.Comment;
import com.zjx.Entity.News;

public class CommentDaoImpl extends BaseDao implements CommentDao{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Comment comment=null;
	int result=0;
	List<Comment> li = new ArrayList<Comment>();
	public List<Comment> showComment() {
		con=this.getConnection();
		try {
			ps=con.prepareStatement("select * from comment");
			rs=ps.executeQuery();
			while(rs.next()){
				comment = new Comment(rs.getInt("id"),rs.getString("content"),rs.getString("createTime"),rs.getString("reply"),rs.getString("replyTime"),rs.getString("name"));
				li.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	
	public Comment findComment(int id) {
		con=this.getConnection();
		try {
			ps=con.prepareStatement("select * from comment where id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()){
				comment = new Comment(rs.getInt("id"),rs.getString("content"),rs.getString("createTime"),rs.getString("reply"),rs.getString("replyTime"),rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}

	public int updateComment(Comment comment) {
		con=this.getConnection();
		try {
			ps=con.prepareStatement("update comment set reply=?,replyTime=? where id=?");
			ps.setString(1,comment.getReply());
			ps.setString(2,comment.getReplyTime());
			ps.setInt(3,comment.getId());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public int deleteComment(int id) {
		con=this.getConnection();
		try {
			ps=con.prepareStatement("delete from comment where id=?");
			ps.setInt(1,id);
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll(con,ps,null);
		}
		return result;
	}

	public List<Comment> showAllCommentByPage(int pageNo, int pageSize) {
		List<Comment> li = new ArrayList<Comment>();
		con =this.getConnection();
		try {
			ps= con.prepareStatement("select * from comment limit ?,?");
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				comment = new Comment(rs.getInt("id"),rs.getString("content"),rs.getString("createTime"),rs.getString("reply"),rs.getString("replyTime"),rs.getString("name"));
				li.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return li;	
	}

	public int countPageByComment() {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select count(id) from comment");
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int addComment(Comment comment) {
		con = this.getConnection();
		try {
			ps = con.prepareStatement("insert into comment(content,createTime,name) values (?,?,?)");
			ps.setString(1, comment.getContent());
			ps.setString(2, comment.getCreateTime());
			ps.setString(3, comment.getName());
			result=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

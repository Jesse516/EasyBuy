package com.zjx.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

public class BaseDao {
	private static String CLASSNAME="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/ppmoney?useUnicode=true&characterEncoding=utf-8";
	private static String USERNAME="root";
	private static String PASSWORD="root";
	
	public int executeUpdate(String sql,Object... paramters){
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			for(int i=0;i<paramters.length;i++){
				ps.setObject((i+1), paramters[i]);
			}
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;	
	}
	
	public Connection getConnection(){
		Connection con=null;
		try {
			Class.forName(CLASSNAME);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeAll(Connection con,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

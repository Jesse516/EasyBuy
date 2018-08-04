package com.zjx.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zjx.Dao.BaseDao;
import com.zjx.Dao.CardPhoneDao;

public class CardPhoneDaoImpl extends BaseDao implements CardPhoneDao{
	Connection con = null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	int result=0;
	public int findCardPhone(String cardNo, String phone) {
		// TODO Auto-generated method stub
		con = this.getConnection();
		try {
			ps = con.prepareStatement("select * from cardphone where cardNo=? and phone=?");
			ps.setString(1, cardNo);
			ps.setString(2, phone);
			rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll(con,ps,rs);
		}
		return result;
	}

}

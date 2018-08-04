package com.zjx.Service.Impl;

import com.zjx.Dao.Impl.CardPhoneDaoImpl;
import com.zjx.Service.CardPhoneService;

public class CardPhoneServiceImpl implements CardPhoneService{
	CardPhoneDaoImpl cdi = new CardPhoneDaoImpl();
	public int findCardPhone(String cardNo, String phone) {
		// TODO Auto-generated method stub
		return cdi.findCardPhone(cardNo, phone);
	}

}

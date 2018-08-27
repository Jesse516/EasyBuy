package org.crm.service.impl;

import org.crm.domain.CstActivity;
import org.crm.mapper.CstActivityMapper;
import org.crm.service.CstActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CstActivityServiceImpl implements CstActivityService {
    @Autowired
    private CstActivityMapper atvMapper;

    @Override
    public List<CstActivity> findAllCstActivity(String atv_cust_no) {
        return atvMapper.findAllCstActivity(atv_cust_no);
    }

    @Override
    public CstActivity findActivityById(int atv_id) {
        return atvMapper.findActivityById(atv_id);
    }

    @Override
    public int updateActivityById(CstActivity cstActivity) {
        return atvMapper.updateActivityById(cstActivity);
    }

    @Override
    public int deleteActivityById(int atv_id) {
        return atvMapper.deleteActivityById(atv_id);
    }

    @Override
    public int addActivity(CstActivity cstActivity) {
        return atvMapper.addActivity(cstActivity);
    }
}

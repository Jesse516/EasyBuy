package org.crm.service.impl;
import org.crm.domain.SvrApi;
import org.crm.mapper.SvrApiMapper;
import org.crm.service.SvrApiServcie;
import org.crm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SvrApiServcieImpl implements SvrApiServcie {
    @Autowired
    private SvrApiMapper svrMapper;

    @Override
    public int addSvrApi(SvrApi svrApi) {
        return svrMapper.addSvrApi(svrApi);
    }

    @Override
    public List<SvrApi> findAllSvrApi(PageUtil pageUtil) {
        int pageNo=pageUtil.getPageNo();
        int pageSize=pageUtil.getPageSize();
        if(pageNo!=0){
            pageUtil.setPageNo((pageNo-1)*pageSize);
        }

        return svrMapper.findAllSvrApi(pageUtil);
    }

    @Override
    public int countSvrApi(PageUtil pageUtil) {
        return svrMapper.countSvrApi(pageUtil);
    }

    @Override
    public int countPage(PageUtil pageUtil) {
        int countRecord=svrMapper.countSvrApi(pageUtil);
        return countRecord%pageUtil.getPageSize()==0 ? countRecord/pageUtil.getPageSize():countRecord/pageUtil.getPageSize()+1;
    }

    @Override
    public int updateSvr(SvrApi svrApi) {
        return svrMapper.updateSvr(svrApi);
    }

    @Override
    public int deleteSvr(int svr_id) {
        return svrMapper.deleteSvr(svr_id);
    }

    @Override
    public SvrApi findById(int svr_id) {
        return svrMapper.findById(svr_id);
    }

    @Override
    public int dealDetailSvr(SvrApi svrApi) {//处理
        return svrMapper.dealDetailSvr(svrApi);
    }

    @Override
    public int feedback(SvrApi svrApi) {//反馈
        return svrMapper.feedback(svrApi);
    }

    @Override
    public List<SvrApi> findList(int year) {
        return svrMapper.findList(year);
    }
}

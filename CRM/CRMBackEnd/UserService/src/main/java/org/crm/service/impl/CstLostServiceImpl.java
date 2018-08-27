package org.crm.service.impl;
import org.crm.domain.CstLost;
import org.crm.mapper.CstLostMapper;
import org.crm.service.CstLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CstLostServiceImpl implements CstLostService {
    @Autowired
    private CstLostMapper cstlMapper;

    @Override
    public List<CstLost> findAllLostByPage(CstLost cstLost) {
        int pageno=cstLost.getPageno();
        int pagesize=cstLost.getPagesize();
        if(pageno!=0){
            cstLost.setPageno((pageno-1)*pagesize);
        }
        return cstlMapper.findAllLostByPage(cstLost);
    }

    @Override
    public int totleRecord(CstLost cstLost) {
        return cstlMapper.totleRecord(cstLost);
    }

    @Override
    public int totlePage(CstLost cstLost) {
        int totleRecord=cstlMapper.totleRecord(cstLost);
        return totleRecord%cstLost.getPagesize()==0 ? totleRecord/cstLost.getPagesize() : totleRecord/cstLost.getPagesize()+1;
    }

    @Override
    public CstLost findCstLostById(int lst_id) {
        return cstlMapper.findCstLostById(lst_id);
    }

    @Override
    public int updateCstLostconfirm(CstLost cstLost) {
        return cstlMapper.updateCstLostconfirm(cstLost);
    }

    @Override
    public int updateCstLostreply(CstLost cstLost) {
        return cstlMapper.updateCstLostreply(cstLost);
    }
}

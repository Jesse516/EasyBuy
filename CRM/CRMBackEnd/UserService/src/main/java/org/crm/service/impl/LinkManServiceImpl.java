package org.crm.service.impl;

import com.netflix.discovery.converters.Auto;
import org.crm.domain.LinkMan;
import org.crm.service.LinkManService;
import org.crm.mapper.LinkManMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkManServiceImpl implements LinkManService {
    @Autowired
    private LinkManMapper lmMapper;
    @Override
    public List<LinkMan> findAllLinkman(String lkm_cust_no) {
        return lmMapper.findAllLinkman(lkm_cust_no);
    }

    @Override
    public LinkMan findById(int lkm_id) {
        return lmMapper.findById(lkm_id);
    }

    @Override
    public int updateLinkManById(LinkMan linkMan) {
        return lmMapper.updateLinkManById(linkMan);
    }

    @Override
    public int addLinkMan(LinkMan linkMan) {
        return lmMapper.addLinkMan(linkMan);
    }

    @Override
    public int deleteLinkManById(int lkm_id) {
        return lmMapper.deleteLinkManById(lkm_id);
    }
}

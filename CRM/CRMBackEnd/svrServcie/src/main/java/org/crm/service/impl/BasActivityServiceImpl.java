package org.crm.service.impl;

import org.crm.domain.BasActivity;
import org.crm.mapper.BasMapper;
import org.crm.service.BasActivityService;
import org.crm.util.BasPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BasActivityServiceImpl implements BasActivityService {
    @Autowired
    private BasMapper basMapper;
    @Override
    public List<BasActivity> findAllPage(BasPageUtil basPageUtil) {
        int pageNo=basPageUtil.getPageNo();
        int pageSize=basPageUtil.getPageSize();
        if(pageNo!=0){
            basPageUtil.setPageNo((pageNo-1)*pageSize);
        }
        return basMapper.findAllPage(basPageUtil);
    }

    @Override
    public int countBasActivity(BasPageUtil basPageUtil) {
        return basMapper.countBasActivity(basPageUtil);
    }

    @Override
    public int countPage(BasPageUtil basPageUtil) {
        int totle=basMapper.countBasActivity(basPageUtil);
        return totle%basPageUtil.getPageSize()==0 ? totle/basPageUtil.getPageSize():totle/basPageUtil.getPageSize()+1;
    }

    @Override
    public BasActivity findById(int dict_id) {
        return basMapper.findById(dict_id);
    }

    @Override
    public int updateBas(BasActivity basActivity) {
        return basMapper.updateBas(basActivity);
    }

    @Override
    public int delBas(int dict_id) {
        return basMapper.delBas(dict_id);
    }

    @Override
    public int addBas(BasActivity basActivity) {
        return basMapper.addBas(basActivity);
    }
}



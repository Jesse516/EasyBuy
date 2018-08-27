package org.crm.controller;

import org.apache.ibatis.annotations.Delete;
import org.crm.domain.LinkMan;
import org.crm.service.LinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinkManController {
    @Autowired
    private LinkManService lmService;

    //显示指定供应商编号下所有联系人
    @GetMapping(value="/findAllLinkMan/{cust_no}",produces="application/json;charset=utf-8")
    public List<LinkMan> findAllMan(@PathVariable("cust_no") String cust_no){
        return lmService.findAllLinkman(cust_no);
    }
    //按编号查找联系人
    @GetMapping(value="/findLinkmanById/{lkm_id}",produces="application/json;charset=utf-8")
    public LinkMan findLinkmanById(@PathVariable("lkm_id") String lkm_id){
        int s_lkm_id=0;

        if(lkm_id!=null && !"".equals(lkm_id)){
            s_lkm_id=Integer.parseInt(lkm_id);
            return lmService.findById(s_lkm_id);
        }
        return null;
    }

    //按编号修改联系人
    @PutMapping(value="/updateLinkManById",produces="application/json;charset=utf-8")
    public Integer updateLinkManById(@RequestBody LinkMan linkMan){
        return lmService.updateLinkManById(linkMan);
    }

    //按添加联指定供应商下联系人
    @PostMapping (value="/addLinkMan",produces="application/json;charset=utf-8")
    public Integer addLinkMan(@RequestBody LinkMan linkMan){
        return lmService.addLinkMan(linkMan);
    }

    //按编号删除联系人，假删除
    @DeleteMapping(value="/delLinkManById/{lkm_id}", produces="application/json;charset=utf-8")
    public Integer delLinkMan( @PathVariable("lkm_id")int lkm_id){
        return lmService.deleteLinkManById(lkm_id);
    }
}

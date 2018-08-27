package org.crm.controller;
import org.crm.domain.CstLost;
import org.crm.service.CstLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CstLostController {
    @Autowired
    private CstLostService cstlService;

    //分页显示总流失客户记录
    @PostMapping(value="/findAllLostCust", produces = "application/json;charset=utf-8")
    public List<CstLost> findAllOrders(@RequestBody CstLost cstLost){
        System.out.println(cstLost.getLst_status());
        if(cstLost.getLst_status().equals("全部")){
            cstLost.setLst_status(null);
        }

        int s_pageno=0;
        if(cstLost.getPageno()==null){
            cstLost.setPageno(1);
        }
        if(cstLost.getPagesize()==null){
            cstLost.setPagesize(2);
        }
        if(cstLost.getPageno()!=null&&cstLost.getPageno()<1){
            cstLost.setPageno(1);
        }

        int  tRecord=cstlService.totleRecord(cstLost);
        int  tPage= cstlService.totlePage(cstLost);
        if(cstLost.getPageno()!=null&&cstLost.getPageno()>tPage){
            cstLost.setPageno(tPage);
        }
;
        s_pageno=cstLost.getPageno();//findAllOrders方法会重置pageno值，所以在调用该方法前先存入变量

        List<CstLost> li=cstlService.findAllLostByPage(cstLost);
        List<CstLost> odrList=new ArrayList<CstLost>();
        for(CstLost odr:li){
            odr.setPageno(cstLost.getPageno());
            odr.setPagesize(cstLost.getPagesize());
            odr.setCountrecord(tRecord);
            odr.setCountpage(tPage);
            odr.setPageno(s_pageno);
            odrList.add(odr);
        }
        return odrList;
    }

    @GetMapping(value="/findCstLostById/{lst_id}", produces = "application/json;charset=utf-8")
    public CstLost findCstLostById(@PathVariable("lst_id") int lst_id){
        return cstlService.findCstLostById(lst_id);
    }

    @PostMapping(value="/updateConfirmLost", produces = "application/json;charset=utf-8")
    public Integer updateConfirmLost(@RequestBody CstLost cstLost){
        return cstlService.updateCstLostconfirm(cstLost);
    }

    @PostMapping(value="/updateReplyLost", produces = "application/json;charset=utf-8")
    public Integer updateReplyLost(@RequestBody CstLost cstLost){
        return cstlService.updateCstLostreply(cstLost);
    }

}

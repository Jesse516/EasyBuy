package org.crm.svrApiController;

import org.crm.domain.BasActivity;
import org.crm.domain.SvrApi;
import org.crm.service.BasActivityService;
import org.crm.util.BasPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BasActivityController {
    @Autowired
    private BasActivityService basService;


    @PostMapping(value="/basActivityFindAll",produces="application/json;charset=utf-8")
    public BasPageUtil findAllBas(@RequestBody BasPageUtil basPageUtil){
        int s_pageno=0;
        if(basPageUtil.getPageNo()==null || basPageUtil.getPageNo().equals("")){
            basPageUtil.setPageNo(1);
        }
        if(basPageUtil.getPageSize()==null || basPageUtil.getPageSize().equals("")){
            basPageUtil.setPageSize(6);
        }
        //如果页码小于1，则指定为1，不能为负数
        if(basPageUtil.getPageNo()!=null && basPageUtil.getPageNo()<1){
            basPageUtil.setPageNo(1);
        }
        int countPage=basService.countPage(basPageUtil);//获得总页数
        int countRecord=basService.countBasActivity(basPageUtil);//获得总条目数

        //如果页码大于总页数，则等于总页数
        if(basPageUtil.getPageNo()!=null && basPageUtil.getPageNo()>countPage){
            basPageUtil.setPageNo(countPage);
        }
        s_pageno=basPageUtil.getPageNo();//findAslChanceByPage方法会重置pageno值使其减去1，所以在调用该方法前先存入变量
       List<BasActivity> li = basService.findAllPage(basPageUtil);//获得信息列表
        if(li!=null){
            basPageUtil.setBaslist(li);
        }else {
            basPageUtil.setBaslist(null);
        }
        //以下为重新赋值，返回前端页面
        basPageUtil.setPageNo(s_pageno);
        basPageUtil.setCountPage(countPage);
        basPageUtil.setCountRecord(countRecord);
        return basPageUtil;

    }

    @GetMapping(value="/basActivityFindById/{dict_id}",produces="application/json;charset=utf-8")
    public BasActivity findById(@PathVariable("dict_id")int dict_id){
        return basService.findById(dict_id);
    }


    @PostMapping(value="/basActivityUpdate",produces="application/json;charset=utf-8")
    public Integer updateById(@RequestBody BasActivity basActivity){
        return basService.updateBas(basActivity);
    }

    @PostMapping(value="/basActivityDel/{dict_id}",produces="application/json;charset=utf-8")
    public Integer delById(@PathVariable("dict_id") int dict_id){
        return basService.delBas(dict_id);
    }

    @PostMapping(value="/basActivityAdd",produces="application/json;charset=utf-8")
    public Integer addById(@RequestBody BasActivity basActivity){
        return basService.addBas(basActivity);
    }


}

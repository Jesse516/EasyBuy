package org.crm.controller;
import org.crm.Util.PageUtil;
import org.crm.domain.AslChance;
import org.crm.service.AslChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AslChanceController {
    @Autowired
    private AslChanceService aslService;
    @PostMapping(value="/findAllAclChance",produces = "application/json;charset=utf-8")
    public PageUtil findAllAclChanceByPage(@RequestBody PageUtil pageUtil){
        int s_pageno=0;
        if(pageUtil.getPageNo()==null || pageUtil.getPageNo().equals("")){
            pageUtil.setPageNo(1);
        }
        if(pageUtil.getPageSize()==null || pageUtil.getPageSize().equals("")){
            pageUtil.setPageSize(2);
        }
        //如果页码小于1，则指定为1，不能为负数
        if(pageUtil.getPageNo()!=null && pageUtil.getPageNo()<1){
            pageUtil.setPageNo(1);
        }

        int countPage=aslService.getCountPage(pageUtil);//获得总页数
        int countRecord=aslService.getCountRecord(pageUtil);//获得总条目数
        //如果页码大于总页数，则等于总页数
        if(pageUtil.getPageNo()!=null && pageUtil.getPageNo()>countPage){
            pageUtil.setPageNo(countPage);
        }
        s_pageno=pageUtil.getPageNo();//findAslChanceByPage方法会重置pageno值使其减去1，所以在调用该方法前先存入变量
        List<AslChance> li = aslService.findAslChanceByPage(pageUtil);//获得信息列表

        //以下为重新赋值，返回前端页面
        pageUtil.setPageNo(s_pageno);
        pageUtil.setCountPage(countPage);
        pageUtil.setCountRecord(countRecord);
        pageUtil.setTlist(li);
        return pageUtil;
    }

    //添加功能
    @PostMapping(value="/addAslChance",produces = "application/josn;charset=utf-8")
    public Integer addChance(@RequestBody AslChance aslChance){
        if(aslChance.getChc_due_to().equals("请选择")){
            aslChance.setChc_due_to(null);
            aslChance.setChc_due_date(null);
            aslChance.setChc_status("未指派");
        }else{
            aslChance.setChc_status("已指派");
        }
        return aslService.addAslChance(aslChance);
    }

    //按编号查找
    @GetMapping(value="/findChance/{chc_id}",produces = "application/json;charset=utf-8")
    public AslChance findById(@PathVariable("chc_id") int chc_id){
        System.out.println(aslService.findById(chc_id));
        return aslService.findById(chc_id);
    }

    //按编号修改
    @PostMapping(value="/updateChance",produces = "application/json;charset=utf-8")
    public Integer updateChance(@RequestBody AslChance aslChance){
        if(!aslChance.getChc_due_to().equals("请选择...")){
            aslChance.setChc_status("已指派");
        }else{
            aslChance.setChc_status("未指派");
        }
        return aslService.updateChance(aslChance);
    }

    //按编号删除
    @GetMapping(value="/deleteChance",produces = "application/json;charset=utf-8")
    public Integer deleteChance(@RequestParam(value="chc_id") int chc_id){
        return aslService.deleteChance(chc_id);
    }


    @PostMapping(value="/updateStatus",produces = "application/json;charset=utf-8")
    public Integer updateStatus(@RequestBody AslChance aslChance){
        return aslService.updateStatus(aslChance);
    }
}

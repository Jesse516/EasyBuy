package org.crm.svrApiController;

import org.apache.ibatis.annotations.Select;
import org.crm.domain.SvrApi;
import org.crm.service.SvrApiServcie;
import org.crm.util.JWTHelper;
import org.crm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SvrApiController {
    @Autowired
    private SvrApiServcie sveService;

    @PostMapping(value="/svrApiAdd",produces = "application/json;charset=utf-8")
    public Integer SvrAdd(@RequestBody SvrApi svrApi){

        String s_token=svrApi.getToken();
        Map<String,String> map=JWTHelper.verifyToken(s_token);
        String username=map.get("username");
        int userId=Integer.parseInt(map.get("userid"));
        svrApi.setSvr_create_id(userId);
        svrApi.setSvr_create_by(username);
        if(svrApi.getSvr_due_to().equals("请选择...")){
            svrApi.setSvr_due_to(null);
        }
        if(svrApi.getSvr_type().equals("请选择...")){
            svrApi.setSvr_type(null);
        }
        if(svrApi.getSvr_request()==null){//如果处理结果为空，则是没处理，把处理时间和满意度都设置为空
            svrApi.setSvr_type(null);
            svrApi.setSvr_deal_date(null);

        }
        return sveService.addSvrApi(svrApi);
    }

    @PostMapping(value="/svrApiFindAll",produces="application/json;charset=utf-8")
    public PageUtil findAllSvrApi(@RequestBody PageUtil pageUtil){
        if(pageUtil.getSvr_type().equals("全部")){
            pageUtil.setSvr_type(null);
        }
        if(pageUtil.getSvr_status().equals("全部")){
            pageUtil.setSvr_status(null);
        }
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
        int countPage=sveService.countPage(pageUtil);//获得总页数
        int countRecord=sveService.countSvrApi(pageUtil);//获得总条目数

        //如果页码大于总页数，则等于总页数
        if(pageUtil.getPageNo()!=null && pageUtil.getPageNo()>countPage){
            pageUtil.setPageNo(countPage);
        }
        s_pageno=pageUtil.getPageNo();//findAslChanceByPage方法会重置pageno值使其减去1，所以在调用该方法前先存入变量
        List<SvrApi> li = sveService.findAllSvrApi(pageUtil);//获得信息列表
        if(li!=null){
            pageUtil.setSvrlist(li);
        }else {
            pageUtil.setSvrlist(null);
        }
        //以下为重新赋值，返回前端页面
        pageUtil.setPageNo(s_pageno);
        pageUtil.setCountPage(countPage);
        pageUtil.setCountRecord(countRecord);


        return pageUtil;

    }


    @PostMapping(value="/updateSvr",produces = "application/json;charset=utf-8")
    public Integer updateSvr(@RequestBody SvrApi svrApi){//分配
        return  sveService.updateSvr(svrApi);
    }

    @PostMapping(value="/dealdeailSvr",produces = "application/json;charset=utf-8")
    public Integer dealdeailSvr(@RequestBody SvrApi svrApi){//处理
        return  sveService.dealDetailSvr(svrApi);
    }


    @PostMapping(value="/feedbackSvr",produces = "application/json;charset=utf-8")
    public Integer feedbackSvr(@RequestBody SvrApi svrApi){//反馈
        return  sveService.dealDetailSvr(svrApi);
    }


    @PostMapping(value="/deleteSvr/{svr_id}",produces = "application/json;charset=utf-8")
    public Integer deleteSvr(@PathVariable("svr_id") int svr_id){
        return  sveService.deleteSvr(svr_id);
    }


    @GetMapping(value="/findBySvr/{svr_id}",produces = "application/json;charset=utf-8")
    public SvrApi findSvr(@PathVariable("svr_id") int svr_id){
        return  sveService.findById(svr_id);
    }


    @GetMapping(value="/findList/{year}",produces = "application/json;charset=utf-8")
    public List<SvrApi> findList(@PathVariable("year") int year){
        return  sveService.findList(year);
    }

}

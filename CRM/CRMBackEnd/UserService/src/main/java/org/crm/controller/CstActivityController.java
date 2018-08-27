package org.crm.controller;

import org.crm.domain.CstActivity;
import org.crm.domain.LinkMan;
import org.crm.service.CstActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@RestController
public class CstActivityController {
    @Autowired
    private CstActivityService atvServcie;

    //分页查询所有
    @GetMapping(value="/findAllCstActivity/{cust_no}",produces = "application/json;charset=utf-8")
    public List<CstActivity> findAllCstActivity(@PathVariable("cust_no")String cust_no){
            return atvServcie.findAllCstActivity(cust_no);
    }

    //按编号查找
    @GetMapping(value="/findActivityById/{atv_id}",produces = "application/json;charset=utf-8")
    public CstActivity findCstActivityById(@PathVariable("atv_id") int atv_id){
        return atvServcie.findActivityById(atv_id);
    }


    //按编号修改
    @PutMapping(value = "/updateActivityById",produces = "application/json;charset=utf-8")
    public Integer updateActivityByNo(@RequestBody CstActivity cstActivity){
     /* cstActivity. getAtv_date();
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(sdf1.parse(cstActivity. getAtv_date())));
        System.out.println(cstActivity.getAtv_date());*/
        int result=atvServcie.updateActivityById(cstActivity);
        return result;
    }

    //按编号删除，真删除
    @DeleteMapping(value = "/delActivityById/{atv_id}", produces = "application/json;charset=utf-8")
    public Integer delActivityById(@PathVariable("atv_id") int atv_id){
        int result=atvServcie.deleteActivityById(atv_id);
        return result;
    }

    //按添加联指定供应商下记录
    @PostMapping (value="/addActivity",produces="application/json;charset=utf-8")
    public Integer addActivity(@RequestBody CstActivity cstActivity){
        return atvServcie.addActivity(cstActivity);
    }

}

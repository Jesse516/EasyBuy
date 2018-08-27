package org.crm.controller;

import org.crm.domain.OrdersProduct;
import org.crm.service.OrdersProductService;
import org.crm.util.ProductPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private OrdersProductService service;

    @PostMapping(value="findAllpro",produces = "application/json;charset=utf-8")
    public ProductPageUtil findAll(@RequestBody ProductPageUtil proPageUtil){
        System.out.println(proPageUtil);
        int s_pageno=0;
        if(proPageUtil.getPageNo()==null || proPageUtil.getPageNo().equals("")){
            proPageUtil.setPageNo(1);
        }
        if(proPageUtil.getPageSize()==null || proPageUtil.getPageSize().equals("")){
            proPageUtil.setPageSize(2);
        }
        //如果页码小于1，则指定为1，不能为负数
        if(proPageUtil.getPageNo()!=null && proPageUtil.getPageNo()<1){
            proPageUtil.setPageNo(1);
        }
        int countPage=service.countPage(proPageUtil);//获得总页数
        int countRecord=service.countProduct(proPageUtil);//获得总条目数

        //如果页码大于总页数，则等于总页数
        if(proPageUtil.getPageNo()!=null && proPageUtil.getPageNo()>countPage){
            proPageUtil.setPageNo(countPage);
        }
        s_pageno=proPageUtil.getPageNo();//findAslChanceByPage方法会重置pageno值使其减去1，所以在调用该方法前先存入变量
        List<OrdersProduct> li = service.findAllProPage(proPageUtil);//获得信息列表
        if(li!=null){
            proPageUtil.setBaslist(li);
        }else {
            proPageUtil.setBaslist(null);
        }
        //以下为重新赋值，返回前端页面
        proPageUtil.setPageNo(s_pageno);
        proPageUtil.setCountPage(countPage);
        proPageUtil.setCountRecord(countRecord);
        return proPageUtil;

    }
}

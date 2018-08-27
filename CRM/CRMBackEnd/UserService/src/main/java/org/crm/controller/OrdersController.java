package org.crm.controller;

import org.crm.domain.Orders;
import org.crm.domain.OrdersLine;
import org.crm.domain.OrdersProduct;
import org.crm.service.OrderLineService;
import org.crm.service.OrdersProductService;
import org.crm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService odrService;

    @Autowired
    private OrderLineService odlService;

    @Autowired
    private OrdersProductService opService;
    //分页显示总定单
    @PostMapping(value="/findAllOrders", produces = "application/json;charset=utf-8")
    public List<Orders> findAllOrders(@RequestBody Orders orders){
        int s_pageno=0;
        if(orders.getPageno()==null){
            orders.setPageno(1);
        }
        if(orders.getPagesize()==null){
            orders.setPagesize(2);
        }
        if(orders.getPageno()!=null&&orders.getPageno()<1){
            orders.setPageno(1);
        }
        int  tRecord=odrService.totleRecord(orders);
        int  tPage= odrService.totlePage(orders);
        if(orders.getPageno()!=null&&orders.getPageno()>tPage){
            orders.setPageno(tPage);
        }

        s_pageno=orders.getPageno();//findAllOrders方法会重置pageno值，所以在调用该方法前先存入变量

        List<Orders> li=odrService.findAllOrders(orders);
        List<Orders> odrList=new ArrayList<Orders>();
        for(Orders odr:li){
            odr.setPageno(orders.getPageno());
            odr.setPagesize(orders.getPagesize());
            odr.setCountrecord(tRecord);
            odr.setCountpage(tPage);
            odr.setPageno(s_pageno);
            odrList.add(odr);
        }
        return odrList;
    }


    //查看订单明细功能
    @GetMapping(value = "/findOrderLine/{odr_id}",produces = "application/json;charset=utf-8")
    public Orders findByOrderId(@PathVariable("odr_id") String odr_id){
            Orders odr=odrService.findById(odr_id);
            List<OrdersLine> li=odlService.findlOrderLineById(odr.getOdr_id());
            for(OrdersLine line:li){
                OrdersProduct product = opService.findProductById(line.getOdd_prod_id());
                line.setProd_name(product.getProd_name());
                odr.addOdrLine(line);
            }
            return odr;
    }





    //统计报表模块第一个功能，显示每个供应商的总订单金额
    @GetMapping(value = "/findOrders",produces = "application/json;charset=utf-8")
    public List<Orders> findOrders(String odr_customer,Integer year){
        //按分组查询所有不重复订单人列表，目的是取到人员编号，利用人员编号查找此人下所有订单
        List<Orders> ordersConsumter=odrService.findOrderByConsumter();
            for(Orders order:ordersConsumter){
                List<Orders> orders=odrService.findOrders(odr_customer,year,order.getOdr_customerno());//根据客户编号查询此客户下所有订单列表
                    double sum=0;
                    for(Orders o:orders){
                        List<OrdersLine> odLineList=odlService.findlOrderLine(o.getOdr_id());//查找出每个订单号下下所有明细列表
                        for(OrdersLine line:odLineList){
                            o.addOdrLine(line);
                        }
                        sum+=o.getSumMoney();
                    }
                    order.setLastMoney(sum);
            }
            return ordersConsumter;
        }
    }
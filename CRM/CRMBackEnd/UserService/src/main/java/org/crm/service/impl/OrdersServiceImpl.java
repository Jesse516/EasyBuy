package org.crm.service.impl;
import org.crm.domain.Orders;
import org.crm.mapper.OrdersMapper;
import org.crm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper odrMapper;

    @Override
    public List<Orders> findAllOrders(Orders orders) {
        int pageno=orders.getPageno();
        int pagesize=orders.getPagesize();
        if(pageno!=0){
            orders.setPageno((pageno-1)*pagesize);
        }
        return odrMapper.findAllOrders(orders);
    }

    @Override
    public int totleRecord(Orders orders) {
        return odrMapper.totleRecord(orders);
    }

    @Override
    public int totlePage(Orders orders) {
        int totleRecord=odrMapper.totleRecord(orders);
        return totleRecord%orders.getPagesize()==0 ? totleRecord/orders.getPagesize() : totleRecord/orders.getPagesize()+1 ;
    }

    @Override
    public Orders findById(String odr_id) {
        return odrMapper.findById(odr_id);
    }

    @Override
    public List<Orders> findOrders(String odr_customer,int year,String odr_customerno) {
        return odrMapper.findOrders(odr_customer,year,odr_customerno);
    }

    @Override
    public List<Orders> findByodr_customerno(String odr_customerno) {
        return odrMapper.findByodr_customerno(odr_customerno);
    }

    @Override
    public List<Orders> findOrderByConsumter() {
        return odrMapper.findOrderByConsumter();
    }

}

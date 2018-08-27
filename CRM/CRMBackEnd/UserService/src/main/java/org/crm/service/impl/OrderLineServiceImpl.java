package org.crm.service.impl;
import org.crm.domain.OrdersLine;
import org.crm.mapper.OrdersLineMapper;
import org.crm.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrdersLineMapper olMapper;

    @Override
    public List<OrdersLine> findlOrderLineById(int odd_order_id) {//根据订单编号查找所有明细
        return olMapper.findlOrderLineById(odd_order_id);
    }


    @Override
    public List<OrdersLine> findlOrderLine(int odd_order_id) {
        return olMapper.findlOrderLine(odd_order_id);
    }
}

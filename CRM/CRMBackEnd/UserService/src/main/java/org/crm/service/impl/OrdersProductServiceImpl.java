package org.crm.service.impl;

import org.crm.domain.OrdersProduct;
import org.crm.mapper.OrdersProductMapper;
import org.crm.service.OrdersProductService;
import org.crm.util.ProductPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersProductServiceImpl implements OrdersProductService {
    @Autowired
   private OrdersProductMapper opMapper;

    @Override
    public OrdersProduct findProductById(int prod_id) {
        return opMapper.findProductById(prod_id);
    }

    @Override
    public List<OrdersProduct> findAllProPage(ProductPageUtil proPageUtil) {
        int pageNo=proPageUtil.getPageNo();
        int pageSize=proPageUtil.getPageSize();
        if(pageNo!=0){
            proPageUtil.setPageNo((pageNo-1)*pageSize);
        }
        return opMapper.findAllProPage(proPageUtil);
    }

    @Override
    public int countProduct(ProductPageUtil proPageUtil) {
        return opMapper.countProduct(proPageUtil);
    }

    @Override
    public int countPage(ProductPageUtil proPageUtil) {
        int totle=opMapper.countProduct(proPageUtil);
        return totle%proPageUtil.getPageSize()==0 ? totle/proPageUtil.getPageSize() :totle/proPageUtil.getPageSize()+1;
    }

}

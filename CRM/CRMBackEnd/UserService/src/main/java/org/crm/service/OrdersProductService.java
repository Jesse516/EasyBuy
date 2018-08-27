package org.crm.service;
import org.apache.ibatis.annotations.Param;
import org.crm.domain.OrdersProduct;
import org.crm.util.ProductPageUtil;

import java.util.List;

public interface OrdersProductService {
    public OrdersProduct findProductById(int prod_id);
    public List<OrdersProduct> findAllProPage(ProductPageUtil proPageUtil);
    public int countProduct(ProductPageUtil proPageUtil);
    public int countPage(ProductPageUtil proPageUtil);

}

package org.crm.service;
import org.crm.domain.Orders;
import java.util.List;

public interface OrdersService {
    public List<Orders> findAllOrders(Orders orders);
    public int totleRecord(Orders orders);
    public int totlePage(Orders orders);
    public Orders findById(String odr_id);
    public List<Orders> findOrders(String odr_customer,int year,String odr_customerno);//做统计报表时要用到不分页的所有
    public List<Orders> findByodr_customerno(String odr_customerno);//做统计报表时要用到
    public List<Orders> findOrderByConsumter();//做统计报表时要用到
}

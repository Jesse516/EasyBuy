package org.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.crm.domain.Orders;

import java.util.List;

public interface OrdersMapper {
    //根据客户显示所有定单，分页显示
    @Select("select * from orders where odr_isdelete=1 and odr_customerno=#{odr_customerno} limit #{pageno},#{pagesize}")
    public List<Orders> findAllOrders(Orders orders);

    //根据客户显示此客户下总订单数
    @Select("select count(1) from orders  where odr_isdelete=1 and odr_customerno=#{odr_customerno}")
    public int totleRecord(Orders orders);

    @Select("select * from orders  where odr_id=#{odr_id}")
    public Orders findById(@Param("odr_id") String odr_id);

    @Select("<script>" +
                "select * from orders where odr_isdelete=1 and odr_customerno=#{odr_customerno}" +
                "<if test=\"odr_customer!=null and odr_customer!='' \">and odr_customer=#{odr_customer}</if>" +
                "<if test=\"year!=null and year!=0\">and year(odr_date)=#{year}</if>" +
            "</script>")
    public List<Orders> findOrders(@Param("odr_customer") String odr_customer,@Param("year") int year,@Param("odr_customerno") String odr_customerno);//做统计报表时要用到不分页的所有

    @Select("select * from orders where odr_customerno=#{odr_customerno}")
    public List<Orders> findByodr_customerno(@Param("odr_customerno") String odr_customerno);

    @Select("SELECT * FROM orders GROUP BY odr_customer")
    public List<Orders> findOrderByConsumter();//做统计报表时根据订单里面用户分组

}

package org.crm.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.crm.domain.OrdersLine;
import java.util.List;

public interface OrdersLineMapper {
    @Select("select o.* ,p.prod_name as prod_name from orders_line o,orders_product p where odd_isdelete=1 and o.odd_prod_id=p.prod_id and odd_order_id=#{odd_order_id}")
    public List<OrdersLine> findlOrderLineById(@Param("odd_order_id") int odd_order_id);

    @Select("select * from orders_line where odd_isdelete=1 and odd_order_id=#{odd_order_id}")
    public List<OrdersLine> findlOrderLine(@Param("odd_order_id") int odd_order_id);
}

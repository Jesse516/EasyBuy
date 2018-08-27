package org.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.crm.domain.OrdersProduct;
import org.crm.util.ProductPageUtil;

import java.util.List;

public interface OrdersProductMapper {
    @Select("select * from orders_product where prod_isdelete=1 and prod_id=#{prod_id}")
    public OrdersProduct findProductById(@Param("prod_id") int prod_id);

    @Select("<script>" +
            "select * from orders_product where 1=1 " +
            "<if test=\"prod_name!=null and prod_name!=''\">and prod_name like concat('%',#{prod_name},'%')</if>" +
            "<if test=\"prod_type!=null and prod_type!=''\">and prod_type like concat('%',#{prod_type},'%')</if>" +
            "<if test=\"prod_batch!=null and prod_batch!=''\">and prod_batch like concat('%',#{prod_batch},'%')</if>" +
            "limit #{pageNo},#{pageSize}" +
            "</script>")
    public List<OrdersProduct> findAllProPage(ProductPageUtil proPageUtil);

    @Select("<script>" +
            "select count(1) from orders_product where 1=1 " +
            "<if test=\"prod_name!=null and prod_name!=''\">and prod_name like concat('%',#{prod_name},'%')</if>" +
            "<if test=\"prod_type!=null and prod_type!=''\">and prod_type like concat('%',#{prod_type},'%')</if>" +
            "<if test=\"prod_batch!=null and prod_batch!=''\">and prod_batch like concat('%',#{prod_batch},'%')</if>" +
            "</script>")
    public int countProduct(ProductPageUtil proPageUtil);

}

package org.crm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.crm.domain.Consumer;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ConsumerMapper {
    @Select("select * from cst_customer where cust_status <>3 ")
    public List<Consumer> findByPage();
    @Select("select * from cst_customer where cust_status <>3 and cust_no=#{cust_no}")
    public Consumer findByNo(@Param("cust_no") String cust_no);
    @Update("update cst_customer set cust_name=#{cust_name},cust_region=#{cust_region},cust_manager_name=#{cust_manager_name},cust_level=#{cust_level},cust_satisfy=#{cust_satisfy},cust_credit=#{cust_credit},cust_addr=#{cust_addr},cust_zip=#{cust_zip},cust_tel=#{cust_tel},cust_fax=#{cust_fax},cust_website=#{cust_website},cust_licence_no=#{cust_licence_no},cust_chieftain=#{cust_chieftain},cust_bankroll=#{cust_bankroll},cust_turnover=#{cust_turnover},cust_bank=#{cust_bank},cust_bank_account=#{cust_bank_account},cust_local_tax_no=#{cust_local_tax_no},cust_national_tax_no=#{cust_national_tax_no} where cust_no=#{cust_no}")
    public int updateConsumer(Consumer consumter);
    @Update("update cst_customer set cust_status=3 where cust_no=#{cust_no}")
    public int deleteConsumerByNo(@Param("cust_no") String cust_no);

    @Select("SELECT cust_level,cust_level_label,cust_satisfy,cust_credit,COUNT(cust_level_label) `count` FROM cst_customer WHERE cust_status<>3 GROUP BY cust_level_label ")
    public List<Consumer> calculateByLabel();//统计报表--按客户类别统计

    @Select("SELECT cust_level,cust_level_label,cust_satisfy,cust_credit,COUNT(cust_level_label) `count` FROM cst_customer WHERE cust_status<>3 GROUP BY cust_credit ")
    public List<Consumer> calculateBycredit();//统计报表--按客户信誉度统计

    @Select("SELECT cust_level,cust_level_label,cust_satisfy,cust_credit,COUNT(cust_level_label) `count` FROM cst_customer WHERE cust_status<>3 GROUP BY cust_satisfy ")
    public List<Consumer> calculateBysatisfy();//统计报表--按客户满意度统计
}

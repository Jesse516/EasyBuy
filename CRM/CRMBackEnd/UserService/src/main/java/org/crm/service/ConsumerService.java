package org.crm.service;
import org.apache.ibatis.annotations.Param;
import org.crm.domain.Consumer;
import java.util.List;

public interface ConsumerService {
    public List<Consumer> findByPage();
    public Consumer findByNo(String cust_no);
    public int updateConsumer(Consumer consumter);
    public int deleteConsumerByNo(String cust_no);
    public List<Consumer> calculateByLabel();//统计报表--客户统计--按等级
    public List<Consumer> calculateBycredit();//统计报表--客户统计--按信誉度
    public List<Consumer> calculateBysatisfy();//统计报表--客户统计--按满意度

}

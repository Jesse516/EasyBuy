package org.crm.service;
import org.apache.ibatis.annotations.Param;
import org.crm.Util.PageUtil;
import org.crm.domain.AslChance;
import java.util.List;

public interface AslChanceService {
    public List<AslChance> findAslChanceByPage(PageUtil pageUtil);//按条件分页查询所有
    public int getCountRecord(PageUtil pageUtil);//按条件查询总数
    public int getCountPage(PageUtil pageUtil);//按条件查询总数
    public int addAslChance(AslChance aslChance);//添加功能
    public AslChance findById(int chc_id);  //按编号查找数据
    public int updateChance(AslChance aslChance);//修改功能
    public int deleteChance(int chc_id);//按编号删除
    public int updateStatus(AslChance aslChance);//此方法是在开发计划模块，计划完成后，会执行开发成功功能时要在对应客户状态改为成功/失败
}

package org.crm.service;
import org.apache.ibatis.annotations.Update;
import org.crm.domain.CstLost;
import java.util.List;

public interface CstLostService {
    public List<CstLost> findAllLostByPage(CstLost cstLost);//分页显示所有
    public int totleRecord(CstLost cstLost);//计算客户流失表里面的记录总数
    public int totlePage(CstLost cstLost);//计算总页数
    public CstLost findCstLostById(int lst_id); //根据编号查找
    public int updateCstLostconfirm(CstLost cstLost);//确认流失修改客户内容（添加流失原因，流失时间，状态改为确认流失）
    public int updateCstLostreply(CstLost cstLost);    //暂缓流失修改客户内容（追加暂缓措施内容，状态改为暂缓流失）
}

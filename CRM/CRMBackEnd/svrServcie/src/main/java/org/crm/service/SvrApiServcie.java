package org.crm.service;
import org.apache.ibatis.annotations.Param;
import org.crm.domain.SvrApi;
import org.crm.util.PageUtil;

import java.util.List;

public interface SvrApiServcie {
    public int addSvrApi(SvrApi svrApi);
    public List<SvrApi> findAllSvrApi(PageUtil pageUtil);
    public int countSvrApi(PageUtil pageUtil);//计算总条目
    public int countPage(PageUtil pageUtil);//总页数
    public int updateSvr(SvrApi svrApi);
    public  int deleteSvr(int svr_id);
    public SvrApi findById(int svr_id);
    public int dealDetailSvr(SvrApi svrApi);//服务处理调用
    public int feedback(SvrApi svrApi);//服务反馈调用
    public List<SvrApi> findList(int year);

}

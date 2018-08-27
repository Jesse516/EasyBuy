package org.crm.service;
import org.apache.ibatis.annotations.Param;
import org.crm.domain.LinkMan;
import java.util.List;

public interface LinkManService {
    public List<LinkMan> findAllLinkman(String lkm_cust_no);
    public LinkMan findById(int lkm_id);
    public int updateLinkManById(LinkMan linkMan);
    public int addLinkMan(LinkMan linkMan);
    public int deleteLinkManById(int lkm_id);
}

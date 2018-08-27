package org.crm.service;
import org.crm.domain.CstActivity;
import java.util.List;

public interface CstActivityService {
    public List<CstActivity> findAllCstActivity(String atv_cust_no);
    public CstActivity findActivityById(int atv_id);
    public int updateActivityById(CstActivity cstActivity);
    public int deleteActivityById(int atv_id);
    public int addActivity(CstActivity cstActivity);

}

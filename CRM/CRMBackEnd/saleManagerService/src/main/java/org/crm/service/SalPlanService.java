package org.crm.service;
import org.crm.domain.AslChance;
import org.crm.domain.SalPlan;

import java.util.List;

public interface SalPlanService {
    public List<SalPlan> findByplanId(int pla_chc_id);
    public int updatePlan(SalPlan salPlan);
    public int deletePlan( int pla_id);
    public int addPlan(SalPlan salPlan);


}

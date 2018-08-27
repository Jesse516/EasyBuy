package org.crm.service.impl;
import org.crm.domain.SalPlan;
import org.crm.mapper.SalPlanMapper;
import org.crm.service.SalPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalPlanServiceImpl implements SalPlanService {
    @Autowired
    private SalPlanMapper salPlanMapper;


    @Override
    public List<SalPlan> findByplanId(int pla_chc_id) {
        return salPlanMapper.findByplanId(pla_chc_id);
    }

    @Override
    public int updatePlan(SalPlan salPlan) {
        return salPlanMapper.updatePlan(salPlan);
    }

    @Override
    public int deletePlan(int pla_id) {
        return salPlanMapper.deletePlan(pla_id);
    }

    @Override
    public int addPlan(SalPlan salPlan) {
        return salPlanMapper.addPlan(salPlan);
    }
}

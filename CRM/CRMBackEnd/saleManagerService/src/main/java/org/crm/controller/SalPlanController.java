package org.crm.controller;
import org.apache.ibatis.annotations.Param;
import org.crm.domain.SalPlan;
import org.crm.service.AslChanceService;
import org.crm.service.SalPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalPlanController {
    @Autowired
    private SalPlanService planServie;
    @Autowired
    private AslChanceService aslService;

    @GetMapping(value="/findById/{pla_chc_id}",produces = "application/json;charset=utf-8")
    public List<SalPlan> findById(@PathVariable("pla_chc_id") int pla_chc_id){
        List<SalPlan> list=planServie.findByplanId(pla_chc_id);
        for(SalPlan li:list){
            li.setChance(aslService.findById(pla_chc_id));
        }
        return list;
    }

    @PostMapping(value="/updatePlan",produces="application/json;charset=utf-8")
    public int updatePlanById(@RequestBody SalPlan salPlan){
        return planServie.updatePlan(salPlan);
    }

    @PostMapping(value="/delPlan",produces="application/json;charset=utf-8")
    public int deletePlanById(@RequestBody SalPlan salPlan){
        return planServie.deletePlan(salPlan.getPla_id());
    }

    @PostMapping(value="/addPlan",produces="application/json;charset=utf-8")
    public int addPlanById(@RequestBody SalPlan salPlan){
        return planServie.addPlan(salPlan);
    }



}

package org.crm.mapper;

import org.apache.ibatis.annotations.*;
import org.crm.domain.SalPlan;

import java.util.List;

public interface SalPlanMapper {
    @Select("select * from sal_plan where pla_chc_id=#{pla_chc_id}")
    public List<SalPlan> findByplanId(@Param("pla_chc_id") int pla_chc_id);
    @Update("<script>update sal_plan <set><if test='pla_todo!=null'> pla_todo=#{pla_todo},</if><if test='pla_result!=null'>pla_result=#{pla_result},</if></set> where pla_id=#{pla_id}</script>")
    public int updatePlan(SalPlan salPlan);

    @Delete("delete from sal_plan where pla_id=#{pla_id}")
    public int deletePlan(@Param("pla_id") int pla_id);

    @Insert("insert into sal_plan (pla_chc_id,pla_date,pla_todo) values(#{pla_chc_id},#{pla_date},#{pla_todo})")
    public int addPlan(SalPlan salPlan);
}

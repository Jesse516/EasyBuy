package org.crm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SalPlan implements Serializable {
    private Integer pla_id;//计划编号,主键--------PK
    private Integer pla_chc_id;//机会编号,外键----------FK
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy-MM-dd HH:mm:ss")
    private Date pla_date;//计划制定时间
    private String pla_todo;//计划项
    private String pla_result;//执行结果
    private AslChance chance;

    public SalPlan() {
    }

    public SalPlan(Integer pla_id, Integer pla_chc_id, Date pla_date, String pla_todo, String pla_result, AslChance chance) {
        this.pla_id = pla_id;
        this.pla_chc_id = pla_chc_id;
        this.pla_date = pla_date;
        this.pla_todo = pla_todo;
        this.pla_result = pla_result;
        this.chance = chance;
    }

    public Integer getPla_id() {
        return pla_id;
    }

    public void setPla_id(Integer pla_id) {
        this.pla_id = pla_id;
    }

    public Integer getPla_chc_id() {
        return pla_chc_id;
    }

    public void setPla_chc_id(Integer pla_chc_id) {
        this.pla_chc_id = pla_chc_id;
    }

    public Date getPla_date() {
        return pla_date;
    }

    public void setPla_date(Date pla_date) {
        this.pla_date = pla_date;
    }

    public String getPla_todo() {
        return pla_todo;
    }

    public void setPla_todo(String pla_todo) {
        this.pla_todo = pla_todo;
    }

    public String getPla_result() {
        return pla_result;
    }

    public void setPla_result(String pla_result) {
        this.pla_result = pla_result;
    }

    public AslChance getChance() {
        return chance;
    }

    public void setChance(AslChance chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "SalPlan{" +
                "pla_id=" + pla_id +
                ", pla_chc_id=" + pla_chc_id +
                ", pla_date=" + pla_date +
                ", pla_todo='" + pla_todo + '\'' +
                ", pla_result='" + pla_result + '\'' +
                ", chance=" + chance +
                '}';
    }
}

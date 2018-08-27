package org.crm.domain;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AslChance implements Serializable {
    private Integer chc_id;//机会编号,主键,自增-----------PK
    private String chc_source;//机会来源
    private String chc_cust_name;//客户名称
    private String chc_title;//机会标题,概要
    private Integer chc_rate;//成功几率
    private String chc_linkman;//联系人
    private String chc_tel;//联系电话
    private String chc_desc;//机会描述
    private Integer chc_create_id;//创建人编号
    private String chc_create_by;//创建人
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'")
    private Date chc_create_date;//创建时间
    private Integer chc_due_id;//指派对象编号
    private String chc_due_to;//指派对象姓名
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy-MM-dd HH:mm:ss")
    private Date chc_due_date;//指派时间
    private String chc_status;//1--未指派,2--已指派,3--开发成功,4--终止开发

    private String token;//验证用的


    private List<SalPlan> plan;//包含一个计划列表






    public AslChance(Integer chc_id, String chc_source, String chc_cust_name, String chc_title, Integer chc_rate, String chc_linkman, String chc_tel, String chc_desc, Integer chc_create_id, String chc_create_by, Date chc_create_date, Integer chc_due_id, String chc_due_to, Date chc_due_date, String chc_status) {
        this.chc_id = chc_id;
        this.chc_source = chc_source;
        this.chc_cust_name = chc_cust_name;
        this.chc_title = chc_title;
        this.chc_rate = chc_rate;
        this.chc_linkman = chc_linkman;
        this.chc_tel = chc_tel;
        this.chc_desc = chc_desc;
        this.chc_create_id = chc_create_id;
        this.chc_create_by = chc_create_by;
        this.chc_create_date = chc_create_date;
        this.chc_due_id = chc_due_id;
        this.chc_due_to = chc_due_to;
        this.chc_due_date = chc_due_date;
        this.chc_status = chc_status;

    }

    public AslChance() {
    }

    public AslChance(Integer chc_id, String chc_source, String chc_cust_name, String chc_title, Integer chc_rate, String chc_linkman, String chc_tel, String chc_desc, Integer chc_create_id, String chc_create_by, Date chc_create_date, Integer chc_due_id, String chc_due_to, Date chc_due_date, String chc_status, String token, List<SalPlan> plan) {
        this.chc_id = chc_id;
        this.chc_source = chc_source;
        this.chc_cust_name = chc_cust_name;
        this.chc_title = chc_title;
        this.chc_rate = chc_rate;
        this.chc_linkman = chc_linkman;
        this.chc_tel = chc_tel;
        this.chc_desc = chc_desc;
        this.chc_create_id = chc_create_id;
        this.chc_create_by = chc_create_by;
        this.chc_create_date = chc_create_date;
        this.chc_due_id = chc_due_id;
        this.chc_due_to = chc_due_to;
        this.chc_due_date = chc_due_date;
        this.chc_status = chc_status;
        this.token = token;
        this.plan = plan;
    }

    public Integer getChc_id() {
        return chc_id;
    }

    public void setChc_id(Integer chc_id) {
        this.chc_id = chc_id;
    }

    public String getChc_source() {
        return chc_source;
    }

    public void setChc_source(String chc_source) {
        this.chc_source = chc_source;
    }

    public String getChc_cust_name() {
        return chc_cust_name;
    }

    public void setChc_cust_name(String chc_cust_name) {
        this.chc_cust_name = chc_cust_name;
    }

    public String getChc_title() {
        return chc_title;
    }

    public void setChc_title(String chc_title) {
        this.chc_title = chc_title;
    }

    public Integer getChc_rate() {
        return chc_rate;
    }

    public void setChc_rate(Integer chc_rate) {
        this.chc_rate = chc_rate;
    }

    public String getChc_linkman() {
        return chc_linkman;
    }

    public void setChc_linkman(String chc_linkman) {
        this.chc_linkman = chc_linkman;
    }

    public String getChc_tel() {
        return chc_tel;
    }

    public void setChc_tel(String chc_tel) {
        this.chc_tel = chc_tel;
    }

    public String getChc_desc() {
        return chc_desc;
    }

    public void setChc_desc(String chc_desc) {
        this.chc_desc = chc_desc;
    }

    public Integer getChc_create_id() {
        return chc_create_id;
    }

    public void setChc_create_id(Integer chc_create_id) {
        this.chc_create_id = chc_create_id;
    }

    public String getChc_create_by() {
        return chc_create_by;
    }

    public void setChc_create_by(String chc_create_by) {
        this.chc_create_by = chc_create_by;
    }

    public Date getChc_create_date() {
        return chc_create_date;
    }

    public void setChc_create_date(Date chc_create_date) {
        this.chc_create_date = chc_create_date;
    }

    public Integer getChc_due_id() {
        return chc_due_id;
    }

    public void setChc_due_id(Integer chc_due_id) {
        this.chc_due_id = chc_due_id;
    }

    public String getChc_due_to() {
        return chc_due_to;
    }

    public void setChc_due_to(String chc_due_to) {
        this.chc_due_to = chc_due_to;
    }

    public Date getChc_due_date() {
        return chc_due_date;
    }

    public void setChc_due_date(Date chc_due_date) {
        this.chc_due_date = chc_due_date;
    }

    public String getChc_status() {
        return chc_status;
    }

    public void setChc_status(String chc_status) {
        this.chc_status = chc_status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<SalPlan> getPlan() {
        return plan;
    }

    public void setPlan(List<SalPlan> plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "AslChance{" +
                "chc_id=" + chc_id +
                ", chc_source='" + chc_source + '\'' +
                ", chc_cust_name='" + chc_cust_name + '\'' +
                ", chc_title='" + chc_title + '\'' +
                ", chc_rate=" + chc_rate +
                ", chc_linkman='" + chc_linkman + '\'' +
                ", chc_tel='" + chc_tel + '\'' +
                ", chc_desc='" + chc_desc + '\'' +
                ", chc_create_id=" + chc_create_id +
                ", chc_create_by='" + chc_create_by + '\'' +
                ", chc_create_date=" + chc_create_date +
                ", chc_due_id=" + chc_due_id +
                ", chc_due_to='" + chc_due_to + '\'' +
                ", chc_due_date=" + chc_due_date +
                ", chc_status='" + chc_status + '\'' +
                ", token='" + token + '\'' +
                ", plan=" + plan +
                '}';
    }
}

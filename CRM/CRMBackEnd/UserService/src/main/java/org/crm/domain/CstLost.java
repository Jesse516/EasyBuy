package org.crm.domain;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CstLost implements Serializable {
    private Integer lst_id;//流失编号,主键--------PK
    private String lst_cust_no;//客户编号,外键----------FK
    private String lst_cust_name;//客户姓名
    private Integer lst_manager_id;//客户经理编号
    private String lst_manager_name;//客户经理
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy'年'MM'月'dd'日'")
    private Date lst_last_order_date;//上次下单时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy'年'MM'月'dd'日'")
    private Date lst_lost_date;//确认流失时间
    private String lst_delay;//暂缓措施
    private String lst_reason;//流失原因
    private String lst_status;//状态1-警告，2-暂缓流失，3-已经流失

    /*以下为做分页用属性*/
    private Integer pageno;//当前页
    private Integer pagesize;//每页显示几条数据
    private Integer countpage;//总页数
    private Integer countrecord;//总条目数
    private int lostyear;//统计模块用

    @Override
    public String toString() {
        return "CstLost{" +
                "lst_id=" + lst_id +
                ", lst_cust_no='" + lst_cust_no + '\'' +
                ", lst_cust_name='" + lst_cust_name + '\'' +
                ", lst_manager_id=" + lst_manager_id +
                ", lst_manager_name='" + lst_manager_name + '\'' +
                ", lst_last_order_date=" + lst_last_order_date +
                ", lst_lost_date=" + lst_lost_date +
                ", lst_delay='" + lst_delay + '\'' +
                ", lst_reason='" + lst_reason + '\'' +
                ", lst_status='" + lst_status + '\'' +
                ", pageno=" + pageno +
                ", pagesize=" + pagesize +
                ", countpage=" + countpage +
                ", countrecord=" + countrecord +
                '}';
    }

    public CstLost() {
    }

    public CstLost(Integer lst_id, String lst_cust_no, String lst_cust_name, Integer lst_manager_id, String lst_manager_name, Date lst_last_order_date, Date lst_lost_date, String lst_delay, String lst_reason, String lst_status, Integer pageno, Integer pagesize, Integer countpage, Integer countrecord) {
        this.lst_id = lst_id;
        this.lst_cust_no = lst_cust_no;
        this.lst_cust_name = lst_cust_name;
        this.lst_manager_id = lst_manager_id;
        this.lst_manager_name = lst_manager_name;
        this.lst_last_order_date = lst_last_order_date;
        this.lst_lost_date = lst_lost_date;
        this.lst_delay = lst_delay;
        this.lst_reason = lst_reason;
        this.lst_status = lst_status;
        this.pageno = pageno;
        this.pagesize = pagesize;
        this.countpage = countpage;
        this.countrecord = countrecord;
    }

    public CstLost(Integer lst_id, String lst_cust_no, String lst_cust_name, Integer lst_manager_id, String lst_manager_name, Date lst_last_order_date, Date lst_lost_date, String lst_delay, String lst_reason, String lst_status) {
        this.lst_id = lst_id;
        this.lst_cust_no = lst_cust_no;
        this.lst_cust_name = lst_cust_name;
        this.lst_manager_id = lst_manager_id;
        this.lst_manager_name = lst_manager_name;
        this.lst_last_order_date = lst_last_order_date;
        this.lst_lost_date = lst_lost_date;
        this.lst_delay = lst_delay;
        this.lst_reason = lst_reason;
        this.lst_status = lst_status;
    }

    public Integer getLst_id() {
        return lst_id;
    }

    public void setLst_id(Integer lst_id) {
        this.lst_id = lst_id;
    }

    public String getLst_cust_no() {
        return lst_cust_no;
    }

    public void setLst_cust_no(String lst_cust_no) {
        this.lst_cust_no = lst_cust_no;
    }

    public String getLst_cust_name() {
        return lst_cust_name;
    }

    public void setLst_cust_name(String lst_cust_name) {
        this.lst_cust_name = lst_cust_name;
    }

    public Integer getLst_manager_id() {
        return lst_manager_id;
    }

    public void setLst_manager_id(Integer lst_manager_id) {
        this.lst_manager_id = lst_manager_id;
    }

    public String getLst_manager_name() {
        return lst_manager_name;
    }

    public void setLst_manager_name(String lst_manager_name) {
        this.lst_manager_name = lst_manager_name;
    }

    public Date getLst_last_order_date() {
        return lst_last_order_date;
    }

    public void setLst_last_order_date(Date lst_last_order_date) {
        this.lst_last_order_date = lst_last_order_date;
    }

    public Date getLst_lost_date() {
        return lst_lost_date;
    }

    public void setLst_lost_date(Date lst_lost_date) {
        this.lst_lost_date = lst_lost_date;
    }

    public String getLst_delay() {
        return lst_delay;
    }

    public void setLst_delay(String lst_delay) {
        this.lst_delay = lst_delay;
    }

    public String getLst_reason() {
        return lst_reason;
    }

    public void setLst_reason(String lst_reason) {
        this.lst_reason = lst_reason;
    }

    public String getLst_status() {
        return lst_status;
    }

    public void setLst_status(String lst_status) {
        this.lst_status = lst_status;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getCountpage() {
        return countpage;
    }

    public void setCountpage(Integer countpage) {
        this.countpage = countpage;
    }

    public Integer getCountrecord() {
        return countrecord;
    }

    public void setCountrecord(Integer countrecord) {
        this.countrecord = countrecord;
    }

    public int getLostyear() {
        return lostyear;
    }

    public void setLostyear(int lostyear) {
        this.lostyear = lostyear;
    }
}

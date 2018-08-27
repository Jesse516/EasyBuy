package org.crm.domain;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CstActivity implements Serializable {
    private Integer atv_id;//记录编号,主键
    private String atv_cust_no;//客户编号,外键
    private String atv_cust_name;//客户姓名
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy'年'MM'月'dd'日'")
    private Date atv_date;//交往时间
    private String atv_place;//交往地点
    private String atv_title;//概要
    private String  atv_desc;//详细信息
    private String atv_memo;//备注信息

    public CstActivity(Integer atv_id, String atv_cust_no, String atv_cust_name, Date atv_date, String atv_place, String atv_title, String atv_desc, String atv_memo) {
        this.atv_id = atv_id;
        this.atv_cust_no = atv_cust_no;
        this.atv_cust_name = atv_cust_name;
        this.atv_date = atv_date;
        this.atv_place = atv_place;
        this.atv_title = atv_title;
        this.atv_desc = atv_desc;
        this.atv_memo = atv_memo;
    }

    public CstActivity() {
    }

    public Integer getAtv_id() {
        return atv_id;
    }

    public void setAtv_id(Integer atv_id) {
        this.atv_id = atv_id;
    }

    public String getAtv_cust_no() {
        return atv_cust_no;
    }

    public void setAtv_cust_no(String atv_cust_no) {
        this.atv_cust_no = atv_cust_no;
    }

    public String getAtv_cust_name() {
        return atv_cust_name;
    }

    public void setAtv_cust_name(String atv_cust_name) {
        this.atv_cust_name = atv_cust_name;
    }

    public Date getAtv_date() {
        return atv_date;
    }

    public void setAtv_date(Date atv_date) {
        this.atv_date = atv_date;
    }

    public String getAtv_place() {
        return atv_place;
    }

    public void setAtv_place(String atv_place) {
        this.atv_place = atv_place;
    }

    public String getAtv_title() {
        return atv_title;
    }

    public void setAtv_title(String atv_title) {
        this.atv_title = atv_title;
    }

    public String getAtv_desc() {
        return atv_desc;
    }

    public void setAtv_desc(String atv_desc) {
        this.atv_desc = atv_desc;
    }

    public String getAtv_memo() {
        return atv_memo;
    }

    public void setAtv_memo(String atv_memo) {
        this.atv_memo = atv_memo;
    }
}

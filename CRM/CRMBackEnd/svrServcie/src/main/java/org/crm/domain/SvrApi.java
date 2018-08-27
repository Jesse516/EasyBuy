package org.crm.domain;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class SvrApi implements Serializable {
    private Integer svr_id;//服务编号,主键--------PK
    private String svr_type;//服务类型
    private String svr_title;//服务概要
    private String svr_cust_no;//客户编号,外键----------FK
    private String svr_cust_name;//客户姓名
    private String svr_status;//状态
    private String svr_request;//服务请求
    private Integer svr_create_id;//创建人编号
    private String svr_create_by;//创建人
    @DateTimeFormat(pattern = "yyyy'-'MM'-'dd HH':'mm':'ss")
    @JSONField(format = "yyyy'年'MM'月'dd'日'")
    private Date svr_create_date;//创建时间
    private Integer svr_due_id;//分配给某人的编号(客户经理编号)
    private String svr_due_to;//分配给xx的姓名
    @DateTimeFormat(pattern = "yyyy'-'MM'-'dd HH':'mm':'ss")
    @JSONField(format = "yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'\"")
    private Date svr_due_date;//分配时间
    private String svr_deal;//服务处理
    private Integer svr_deal_id;//处理人编号
    private String svr_deal_by;//处理人
    @DateTimeFormat(pattern = "yyyy'-'MM'-'dd HH':'mm':'ss")
    @JSONField(format = "yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'")
    private Date svr_deal_date;//处理时间
    private String svr_result;//处理结果
    private Integer svr_satisfy;//满意度
    private String token;//传后台，取到创建者编号和名称

    private Integer number;//统计模块用到

    public SvrApi() {
    }

    public SvrApi(Integer svr_id, String svr_type, String svr_title, String svr_cust_no, String svr_cust_name, String svr_status, String svr_request, Integer svr_create_id, String svr_create_by, Date svr_create_date, Integer svr_due_id, String svr_due_to, Date svr_due_date, String svr_deal, Integer svr_deal_id, String svr_deal_by, Date svr_deal_date, String svr_result, Integer svr_satisfy) {
        this.svr_id = svr_id;
        this.svr_type = svr_type;
        this.svr_title = svr_title;
        this.svr_cust_no = svr_cust_no;
        this.svr_cust_name = svr_cust_name;
        this.svr_status = svr_status;
        this.svr_request = svr_request;
        this.svr_create_id = svr_create_id;
        this.svr_create_by = svr_create_by;
        this.svr_create_date = svr_create_date;
        this.svr_due_id = svr_due_id;
        this.svr_due_to = svr_due_to;
        this.svr_due_date = svr_due_date;
        this.svr_deal = svr_deal;
        this.svr_deal_id = svr_deal_id;
        this.svr_deal_by = svr_deal_by;
        this.svr_deal_date = svr_deal_date;
        this.svr_result = svr_result;
        this.svr_satisfy = svr_satisfy;
    }

    public Integer getSvr_id() {
        return svr_id;
    }

    public void setSvr_id(Integer svr_id) {
        this.svr_id = svr_id;
    }

    public String getSvr_type() {
        return svr_type;
    }

    public void setSvr_type(String svr_type) {
        this.svr_type = svr_type;
    }

    public String getSvr_title() {
        return svr_title;
    }

    public void setSvr_title(String svr_title) {
        this.svr_title = svr_title;
    }

    public String getSvr_cust_no() {
        return svr_cust_no;
    }

    public void setSvr_cust_no(String svr_cust_no) {
        this.svr_cust_no = svr_cust_no;
    }

    public String getSvr_cust_name() {
        return svr_cust_name;
    }

    public void setSvr_cust_name(String svr_cust_name) {
        this.svr_cust_name = svr_cust_name;
    }

    public String getSvr_status() {
        return svr_status;
    }

    public void setSvr_status(String svr_status) {
        this.svr_status = svr_status;
    }

    public String getSvr_request() {
        return svr_request;
    }

    public void setSvr_request(String svr_request) {
        this.svr_request = svr_request;
    }

    public Integer getSvr_create_id() {
        return svr_create_id;
    }

    public void setSvr_create_id(Integer svr_create_id) {
        this.svr_create_id = svr_create_id;
    }

    public String getSvr_create_by() {
        return svr_create_by;
    }

    public void setSvr_create_by(String svr_create_by) {
        this.svr_create_by = svr_create_by;
    }

    public Date getSvr_create_date() {
        return svr_create_date;
    }

    public void setSvr_create_date(Date svr_create_date) {
        this.svr_create_date = svr_create_date;
    }

    public Integer getSvr_due_id() {
        return svr_due_id;
    }

    public void setSvr_due_id(Integer svr_due_id) {
        this.svr_due_id = svr_due_id;
    }

    public String getSvr_due_to() {
        return svr_due_to;
    }

    public void setSvr_due_to(String svr_due_to) {
        this.svr_due_to = svr_due_to;
    }

    public Date getSvr_due_date() {
        return svr_due_date;
    }

    public void setSvr_due_date(Date svr_due_date) {
        this.svr_due_date = svr_due_date;
    }

    public String getSvr_deal() {
        return svr_deal;
    }

    public void setSvr_deal(String svr_deal) {
        this.svr_deal = svr_deal;
    }

    public Integer getSvr_deal_id() {
        return svr_deal_id;
    }

    public void setSvr_deal_id(Integer svr_deal_id) {
        this.svr_deal_id = svr_deal_id;
    }

    public String getSvr_deal_by() {
        return svr_deal_by;
    }

    public void setSvr_deal_by(String svr_deal_by) {
        this.svr_deal_by = svr_deal_by;
    }

    public Date getSvr_deal_date() {
        return svr_deal_date;
    }

    public void setSvr_deal_date(Date svr_deal_date) {
        this.svr_deal_date = svr_deal_date;
    }

    public String getSvr_result() {
        return svr_result;
    }

    public void setSvr_result(String svr_result) {
        this.svr_result = svr_result;
    }

    public Integer getSvr_satisfy() {
        return svr_satisfy;
    }

    public void setSvr_satisfy(Integer svr_satisfy) {
        this.svr_satisfy = svr_satisfy;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SvrService{" +
                "svr_id=" + svr_id +
                ", svr_type='" + svr_type + '\'' +
                ", svr_title='" + svr_title + '\'' +
                ", svr_cust_no='" + svr_cust_no + '\'' +
                ", svr_cust_name='" + svr_cust_name + '\'' +
                ", svr_status='" + svr_status + '\'' +
                ", svr_request='" + svr_request + '\'' +
                ", svr_create_id=" + svr_create_id +
                ", svr_create_by='" + svr_create_by + '\'' +
                ", svr_create_date=" + svr_create_date +
                ", svr_due_id=" + svr_due_id +
                ", svr_due_to='" + svr_due_to + '\'' +
                ", svr_due_date=" + svr_due_date +
                ", svr_deal='" + svr_deal + '\'' +
                ", svr_deal_id=" + svr_deal_id +
                ", svr_deal_by='" + svr_deal_by + '\'' +
                ", svr_deal_date=" + svr_deal_date +
                ", svr_result='" + svr_result + '\'' +
                ", svr_satisfy=" + svr_satisfy +
                '}';
    }

}

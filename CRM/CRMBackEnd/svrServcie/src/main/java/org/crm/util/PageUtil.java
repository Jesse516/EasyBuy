package org.crm.util;
import com.alibaba.fastjson.annotation.JSONField;
import org.crm.domain.SvrApi;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PageUtil implements Serializable {
    private Integer pageNo;//页码
    private Integer pageSize;//每页显示数量
    private Integer countPage;//总页数
    private Integer countRecord;//总条目数
    private String svr_cust_name;//客户名字
    private String svr_title;//概要
    private String svr_type;//服务类型

    private String start_svr_create_date;//创建开始日期

    private String end_svr_create_date;//创建开始日期
    private String svr_status;//状态
    private List<SvrApi> svrlist;

    public PageUtil() {
    }

    public PageUtil(Integer pageNo, Integer pageSize, Integer countPage, Integer countRecord, String svr_cust_name, String svr_title, String svr_type,String start_svr_create_date, String end_svr_create_date, String svr_status, List<SvrApi> svrlist) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.countPage = countPage;
        this.countRecord = countRecord;
        this.svr_cust_name = svr_cust_name;
        this.svr_title = svr_title;
        this.svr_type = svr_type;
        this.start_svr_create_date = start_svr_create_date;
        this.end_svr_create_date = end_svr_create_date;
        this.svr_status = svr_status;
        this.svrlist = svrlist;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public Integer getCountRecord() {
        return countRecord;
    }

    public void setCountRecord(Integer countRecord) {
        this.countRecord = countRecord;
    }

    public String getSvr_cust_name() {
        return svr_cust_name;
    }

    public void setSvr_cust_name(String svr_cust_name) {
        this.svr_cust_name = svr_cust_name;
    }

    public String getSvr_title() {
        return svr_title;
    }

    public void setSvr_title(String svr_title) {
        this.svr_title = svr_title;
    }

    public String getSvr_type() {
        return svr_type;
    }

    public void setSvr_type(String svr_type) {
        this.svr_type = svr_type;
    }

    public String getStart_svr_create_date() {
        return start_svr_create_date;
    }

    public void setStart_svr_create_date(String start_svr_create_date) {
        this.start_svr_create_date = start_svr_create_date;
    }

    public String getEnd_svr_create_date() {
        return end_svr_create_date;
    }

    public void setEnd_svr_create_date(String end_svr_create_date) {
        this.end_svr_create_date = end_svr_create_date;
    }

    public String getSvr_status() {
        return svr_status;
    }

    public void setSvr_status(String svr_status) {
        this.svr_status = svr_status;
    }

    public List<SvrApi> getSvrlist() {
        return svrlist;
    }

    public void setSvrlist(List<SvrApi> svrlist) {
        this.svrlist = svrlist;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", countPage=" + countPage +
                ", countRecord=" + countRecord +
                ", svr_cust_name='" + svr_cust_name + '\'' +
                ", svr_title='" + svr_title + '\'' +
                ", svr_type='" + svr_type + '\'' +
                ", start_svr_create_date=" + start_svr_create_date +
                ", end_svr_create_date=" + end_svr_create_date +
                ", svr_status='" + svr_status + '\'' +
                ", svrlist=" + svrlist +
                '}';
    }
}

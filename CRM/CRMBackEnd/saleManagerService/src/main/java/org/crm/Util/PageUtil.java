package org.crm.Util;
import org.crm.domain.AslChance;
import java.io.Serializable;
import java.util.List;

public class PageUtil  implements Serializable {
    private Integer pageNo;//页码
    private Integer pageSize;//每页显示数量
    private Integer countPage;//总页数
    private Integer countRecord;//总条目数
    private String cust_name;//客户名字
    private String c_title;//概要
    private String linkManName;//联系人姓名
    private List<AslChance> tlist;//
    private String chc_status;

    public PageUtil() {
    }

    public PageUtil(Integer pageNo, Integer pageSize, Integer countPage, Integer countRecord, String cust_name, String c_title, String linkManName, List<AslChance> tlist, String chc_status) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.countPage = countPage;
        this.countRecord = countRecord;
        this.cust_name = cust_name;
        this.c_title = c_title;
        this.linkManName = linkManName;
        this.tlist = tlist;
        this.chc_status = chc_status;
    }

    public PageUtil(Integer pageNo, Integer pageSize, Integer countPage, Integer countRecord, String cust_name, String c_title, String linkManName, List<AslChance> tlist) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.countPage = countPage;
        this.countRecord = countRecord;
        this.cust_name = cust_name;
        this.c_title = c_title;
        this.linkManName = linkManName;
        this.tlist = tlist;
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

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getC_title() {
        return c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getLinkManName() {
        return linkManName;
    }

    public void setLinkManName(String linkManName) {
        this.linkManName = linkManName;
    }

    public List<AslChance> getTlist() {
        return tlist;
    }

    public void setTlist(List<AslChance> tlist) {
        this.tlist = tlist;
    }

    public String getChc_status() {
        return chc_status;
    }

    public void setChc_status(String chc_status) {
        this.chc_status = chc_status;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", countPage=" + countPage +
                ", countRecord=" + countRecord +
                ", cust_name='" + cust_name + '\'' +
                ", c_title='" + c_title + '\'' +
                ", linkManName='" + linkManName + '\'' +
                ", tlist=" + tlist +
                '}';
    }

}

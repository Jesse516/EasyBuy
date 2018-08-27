package org.crm.util;

import org.crm.domain.BasActivity;

import java.util.List;

public class BasPageUtil {
    private Integer pageNo;//页码
    private Integer pageSize;//每页显示数量
    private Integer countPage;//总页数
    private Integer countRecord;//总条目数

    private String dict_type;//类别
    private String dict_item;//条目
    private String dict_value;//值

    private List<BasActivity> baslist;

    public BasPageUtil() {
    }

    public BasPageUtil(Integer pageNo, Integer pageSize, Integer countPage, Integer countRecord, String dict_type, String dict_item, String dict_value, List<BasActivity> baslist) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.countPage = countPage;
        this.countRecord = countRecord;
        this.dict_type = dict_type;
        this.dict_item = dict_item;
        this.dict_value = dict_value;
        this.baslist = baslist;
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

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type;
    }

    public String getDict_item() {
        return dict_item;
    }

    public void setDict_item(String dict_item) {
        this.dict_item = dict_item;
    }

    public String getDict_value() {
        return dict_value;
    }

    public void setDict_value(String dict_value) {
        this.dict_value = dict_value;
    }

    public List<BasActivity> getBaslist() {
        return baslist;
    }

    public void setBaslist(List<BasActivity> baslist) {
        this.baslist = baslist;
    }

    @Override
    public String toString() {
        return "BasPageUtil{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", countPage=" + countPage +
                ", countRecord=" + countRecord +
                ", dict_type='" + dict_type + '\'' +
                ", dict_item='" + dict_item + '\'' +
                ", dict_value='" + dict_value + '\'' +
                ", baslist=" + baslist +
                '}';
    }
}

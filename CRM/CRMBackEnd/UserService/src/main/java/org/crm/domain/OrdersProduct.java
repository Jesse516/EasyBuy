package org.crm.domain;
import java.io.Serializable;

public class OrdersProduct implements Serializable {
    private Integer prod_id;//产品编号,PK----------主键
    private String prod_name;//产品名称
    private String prod_type;//产品型号
    private String prod_batch;//产品批次
    private String prod_unit;//产品单位
    private Double prod_price;//单价
    private String prod_memo;//备注
    private Integer prod_isdelete;//0 删除 1 正常

    public OrdersProduct(Integer prod_id, String prod_name, String prod_type, String prod_batch, String prod_unit, Double prod_price, String prod_memo, Integer prod_isdelete) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_type = prod_type;
        this.prod_batch = prod_batch;
        this.prod_unit = prod_unit;
        this.prod_price = prod_price;
        this.prod_memo = prod_memo;
        this.prod_isdelete = prod_isdelete;
    }

    public OrdersProduct() {
    }

    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_type() {
        return prod_type;
    }

    public void setProd_type(String prod_type) {
        this.prod_type = prod_type;
    }

    public String getProd_batch() {
        return prod_batch;
    }

    public void setProd_batch(String prod_batch) {
        this.prod_batch = prod_batch;
    }

    public String getProd_unit() {
        return prod_unit;
    }

    public void setProd_unit(String prod_unit) {
        this.prod_unit = prod_unit;
    }

    public Double getProd_price() {
        return prod_price;
    }

    public void setProd_price(Double prod_price) {
        this.prod_price = prod_price;
    }

    public String getProd_memo() {
        return prod_memo;
    }

    public void setProd_memo(String prod_memo) {
        this.prod_memo = prod_memo;
    }

    public Integer getProd_isdelete() {
        return prod_isdelete;
    }

    public void setProd_isdelete(Integer prod_isdelete) {
        this.prod_isdelete = prod_isdelete;
    }
}




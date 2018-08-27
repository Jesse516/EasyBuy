package org.crm.domain;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OrdersLine implements Serializable {
    private Integer odd_id;//编号,PK----------主键
    private Integer odd_order_id;//订单编号,FK------------外键
    private Integer odd_prod_id;//产品编号,FK------------外键
    private Integer odd_count;//数量
    private String odd_unit;//单位
    private Double odd_price;//单价
    private Integer odd_isdelete;//0 删除 1 正常
    /*以下为关联商品表中字段内容*/
    private String prod_name;//商品名称
    private Double totleMoney;//一单订单明细总金额





    /*private OrdersProduct odrProduct;//引入商品类

    public void getProductName(OrdersProduct product) {
        if (odrProduct.getProd_id() == product.getProd_id()) {
            odrProduct.setProd_name(product.getProd_name());//把传入商品名称替换给明细里面商品的名称
        }
    }*/

    public OrdersLine() {
    }

    public OrdersLine(Integer odd_id, Integer odd_order_id, Integer odd_prod_id, Integer odd_count, String odd_unit, Double odd_price, Integer odd_isdelete, Double totleMoney) {
        this.odd_id = odd_id;
        this.odd_order_id = odd_order_id;
        this.odd_prod_id = odd_prod_id;
        this.odd_count = odd_count;
        this.odd_unit = odd_unit;
        this.odd_price = odd_price;
        this.odd_isdelete = odd_isdelete;
        this.totleMoney = totleMoney;
    }

    public Integer getOdd_id() {
        return odd_id;
    }

    public void setOdd_id(Integer odd_id) {
        this.odd_id = odd_id;
    }

    public Integer getOdd_order_id() {
        return odd_order_id;
    }

    public void setOdd_order_id(Integer odd_order_id) {
        this.odd_order_id = odd_order_id;
    }

    public Integer getOdd_prod_id() {
        return odd_prod_id;
    }

    public void setOdd_prod_id(Integer odd_prod_id) {
        this.odd_prod_id = odd_prod_id;
    }

    public Integer getOdd_count() {
        return odd_count;
    }

    public void setOdd_count(Integer odd_count) {
        this.odd_count = odd_count;
    }

    public String getOdd_unit() {
        return odd_unit;
    }

    public void setOdd_unit(String odd_unit) {
        this.odd_unit = odd_unit;
    }

    public Double getOdd_price() {
        return odd_price;
    }

    public void setOdd_price(Double odd_price) {
        this.odd_price = odd_price;
    }

    public Integer getOdd_isdelete() {
        return odd_isdelete;
    }

    public void setOdd_isdelete(Integer odd_isdelete) {
        this.odd_isdelete = odd_isdelete;
    }

    public void setTotleMoney(Double totleMoney) {
        this.totleMoney = totleMoney;
    }

    /*public OrdersProduct getOdrProduct() {
        return odrProduct;
    }

    public void setOdrProduct(OrdersProduct odrProduct) {
        this.odrProduct = odrProduct;
    }*/

    public Double getTotleMoney() {
        return odd_count * odd_price;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    @Override
    public String toString() {
        return "OrdersLine{" +
                "odd_id=" + odd_id +
                ", odd_order_id=" + odd_order_id +
                ", odd_prod_id=" + odd_prod_id +
                ", odd_count=" + odd_count +
                ", odd_unit='" + odd_unit + '\'' +
                ", odd_price=" + odd_price +
                ", odd_isdelete=" + odd_isdelete +
                ", prod_name='" + prod_name + '\'' +
                ", totleMoney=" + totleMoney +
                '}';
    }
}

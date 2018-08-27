package org.crm.domain;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Orders implements Serializable {
    private Integer odr_id;//订单编号
    private String odr_customerno;//客户编号
    private String odr_customer;//客户姓名
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format= "yyyy'年'MM'月'dd'日'")
    private Date odr_date;//下单时间
    private String odr_addr;//送货地址
    private String odr_status;//状态:1-新创建2-已确认3-正配货4-已发货5-正在派件6-已回款
    private Integer odr_isdelete;// 是否被删除 0 删除 1 正常

    /*以下为做分页用属性*/
    private Integer pageno;//当前页
    private Integer pagesize;//每页显示几条数据
    private Integer countpage;//总页数
    private Integer countrecord;//总条目数

    private  Double sumMoney;//指定订单号下所有明细金额加起来总金额
    private List<OrdersLine> lines = new LinkedList<OrdersLine>();//设置明细列表

    private double lastMoney;//为了做统计报表客户总金额，单独设置一个变量存储金额

    //订单添加明细列表
    public void addOdrLine(OrdersLine ol){
        for(OrdersLine line:lines){
            if(ol.getOdd_prod_id()==line.getOdd_prod_id()){
                line.setOdd_count(line.getOdd_count()+1);
                return;
            }
        }
        lines.add(ol);
    }


    public Orders(Integer odr_id, String odr_customerno, String odr_customer, Date odr_date, String odr_addr, String odr_status, Integer odr_isdelete, Integer pageno, Integer pagesize, Integer countpage, Integer countrecord, Double sumMoney, List<OrdersLine> lines) {
        this.odr_id = odr_id;
        this.odr_customerno = odr_customerno;
        this.odr_customer = odr_customer;
        this.odr_date = odr_date;
        this.odr_addr = odr_addr;
        this.odr_status = odr_status;
        this.odr_isdelete = odr_isdelete;
        this.pageno = pageno;
        this.pagesize = pagesize;
        this.countpage = countpage;
        this.countrecord = countrecord;
        this.sumMoney = sumMoney;
        this.lines = lines;
    }

    public Orders() {
    }

    public Orders(Double sumMoney, List<OrdersLine> lines) {
        this.sumMoney = sumMoney;
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "odr_id=" + odr_id +
                ", odr_customerno='" + odr_customerno + '\'' +
                ", odr_customer='" + odr_customer + '\'' +
                ", odr_date=" + odr_date +
                ", odr_addr='" + odr_addr + '\'' +
                ", odr_status='" + odr_status + '\'' +
                ", odr_isdelete=" + odr_isdelete +
                ", pageno=" + pageno +
                ", pagesize=" + pagesize +
                ", countpage=" + countpage +
                ", countrecord=" + countrecord +
                ", sumMoney=" + sumMoney +
                ", lines=" + lines +
                ", lastMoney=" + lastMoney +
                '}';
    }

    public Integer getOdr_id() {
        return odr_id;
    }

    public void setOdr_id(Integer odr_id) {
        this.odr_id = odr_id;
    }

    public String getOdr_customerno() {
        return odr_customerno;
    }

    public void setOdr_customerno(String odr_customerno) {
        this.odr_customerno = odr_customerno;
    }

    public String getOdr_customer() {
        return odr_customer;
    }

    public void setOdr_customer(String odr_customer) {
        this.odr_customer = odr_customer;
    }

    public Date getOdr_date() {
        return odr_date;
    }

    public void setOdr_date(Date odr_date) {
        this.odr_date = odr_date;
    }

    public String getOdr_addr() {
        return odr_addr;
    }

    public void setOdr_addr(String odr_addr) {
        this.odr_addr = odr_addr;
    }

    public String getOdr_status() {
        return odr_status;
    }

    public void setOdr_status(String odr_status) {
        this.odr_status = odr_status;
    }

    public Integer getOdr_isdelete() {
        return odr_isdelete;
    }

    public void setOdr_isdelete(Integer odr_isdelete) {
        this.odr_isdelete = odr_isdelete;
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

    public Double getSumMoney() {
        Double finalMoney=0.0;
        for(OrdersLine line:lines){
            finalMoney+=line.getTotleMoney();
        }
        return finalMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public List<OrdersLine> getLines() {
        return lines;
    }

    public void setLines(List<OrdersLine> lines) {
        this.lines = lines;
    }

    public double getLastMoney() {
        return lastMoney;
    }

    public void setLastMoney(double lastMoney) {
        this.lastMoney = lastMoney;
    }
}

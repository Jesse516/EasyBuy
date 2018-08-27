package org.crm.util;
import org.crm.domain.OrdersProduct;
import java.util.List;

public class ProductPageUtil {
    private Integer pageNo;//页码
    private Integer pageSize;//每页显示数量
    private Integer countPage;//总页数
    private Integer countRecord;//总条目数

    private String prod_name;//名称
    private String prod_type;//型号
    private String prod_batch;//批次

    private List<OrdersProduct> baslist;

    public ProductPageUtil(Integer pageNo, Integer pageSize, Integer countPage, Integer countRecord, String prod_name, String prod_type, String prod_batch, List<OrdersProduct> baslist) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.countPage = countPage;
        this.countRecord = countRecord;
        this.prod_name = prod_name;
        this.prod_type = prod_type;
        this.prod_batch = prod_batch;
        this.baslist = baslist;
    }

    public ProductPageUtil() {
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

    public List<OrdersProduct> getBaslist() {
        return baslist;
    }

    public void setBaslist(List<OrdersProduct> baslist) {
        this.baslist = baslist;
    }

    @Override
    public String toString() {
        return "ProductPageUtil{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", countPage=" + countPage +
                ", countRecord=" + countRecord +
                ", prod_name='" + prod_name + '\'' +
                ", prod_type='" + prod_type + '\'' +
                ", prod_batch='" + prod_batch + '\'' +
                ", baslist=" + baslist +
                '}';
    }
}

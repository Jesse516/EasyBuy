package org.crm.domain;
import java.io.Serializable;

public class BasActivity implements Serializable {
    private Integer dict_id;//编号
    private String dict_type;//类别
    private String dict_item;//条目
    private String dict_value;//值
    private String dict_id_editable;//是否可编辑:0-- 不可以 1-- 可以

    public BasActivity() {
    }

    public BasActivity(Integer dict_id, String dict_type, String dict_item, String dict_value, String dict_id_editable) {
        this.dict_id = dict_id;
        this.dict_type = dict_type;
        this.dict_item = dict_item;
        this.dict_value = dict_value;
        this.dict_id_editable = dict_id_editable;
    }

    public Integer getDict_id() {
        return dict_id;
    }

    public void setDict_id(Integer dict_id) {
        this.dict_id = dict_id;
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

    public String getDict_id_editable() {
        return dict_id_editable;
    }

    public void setDict_id_editable(String dict_id_editable) {
        this.dict_id_editable = dict_id_editable;
    }

    @Override
    public String toString() {
        return "BasActivity{" +
                "dict_id=" + dict_id +
                ", dict_type='" + dict_type + '\'' +
                ", dict_item='" + dict_item + '\'' +
                ", dict_value='" + dict_value + '\'' +
                ", dict_id_editable='" + dict_id_editable + '\'' +
                '}';
    }
}

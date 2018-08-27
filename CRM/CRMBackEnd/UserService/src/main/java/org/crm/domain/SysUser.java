package org.crm.domain;
import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer usr_id;//用户编号
    private String usr_name;
    private String usr_password;
    private Integer usr_role_id; //角色编号,外键
    private Integer usr_flag; //状态(0:已删除,1:正常)

    private String token;//设置token属性，做验证时存放token信息

    public SysUser() {
    }

    public SysUser(Integer usr_id, String usr_name, String usr_password, Integer usr_role_id, Integer usr_flag, String token) {
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_password = usr_password;
        this.usr_role_id = usr_role_id;
        this.usr_flag = usr_flag;
        this.token = token;
    }

    public SysUser(Integer usr_id, String usr_name, String usr_password, Integer usr_role_id, Integer usr_flag) {
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_password = usr_password;
        this.usr_role_id = usr_role_id;
        this.usr_flag = usr_flag;
    }

    public Integer getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Integer usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    public Integer getUsr_role_id() {
        return usr_role_id;
    }

    public void setUsr_role_id(Integer usr_role_id) {
        this.usr_role_id = usr_role_id;
    }

    public Integer getUsr_flag() {
        return usr_flag;
    }

    public void setUsr_flag(Integer usr_flag) {
        this.usr_flag = usr_flag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "usr_id=" + usr_id +
                ", usr_name='" + usr_name + '\'' +
                ", usr_password='" + usr_password + '\'' +
                ", usr_role_id=" + usr_role_id +
                ", usr_flag=" + usr_flag +
                '}';
    }
}

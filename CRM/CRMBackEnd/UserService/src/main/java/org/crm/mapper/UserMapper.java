package org.crm.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.crm.domain.SysUser;

import java.util.List;

public interface UserMapper {
    //登录功能
    @Select("select * from sys_user where usr_name=#{usr_name} and usr_password=#{usr_password} and usr_flag=1")
    public SysUser findByNameAndPwd(@Param("usr_name")String usr_name, @Param("usr_password")String usr_password);

    @Select("select * from sys_user where usr_flag=1")
    public List<SysUser> findAllSysUser();//查询所有用户

    @Select("select * from sys_user where usr_flag=1 and usr_id=#{usr_id}")
    public SysUser findById(@Param("usr_id") int usr_id);
}

package org.crm.mapper;

import org.apache.ibatis.annotations.*;
import org.crm.domain.BasActivity;
import org.crm.util.BasPageUtil;

import java.util.List;

public interface BasMapper {

    @Select("<script>" +
            "select * from bas_activity where 1=1 " +
            "<if test=\"dict_type!=null and dict_type!=''\">and dict_type like concat('%',#{dict_type},'%')</if>" +
            "<if test=\"dict_item!=null and dict_item!=''\">and dict_item like concat('%',#{dict_item},'%')</if>" +
            "<if test=\"dict_value!=null and dict_value!=''\">and dict_value like concat('%',#{dict_value},'%')</if>" +
            "limit #{pageNo},#{pageSize}" +
            "</script>")
    public List<BasActivity> findAllPage(BasPageUtil basPageUtil);

    @Select("<script>" +
            "select count(1) from bas_activity where 1=1 " +
            "<if test=\"dict_type!=null and dict_type!=''\">and dict_type like concat('%',#{dict_type},'%')</if>" +
            "<if test=\"dict_item!=null and dict_item!=''\">and dict_item like concat('%',#{dict_item},'%')</if>" +
            "<if test=\"dict_value!=null and dict_value!='' \">and dict_value like concat('%',#{dict_value},'%')</if>" +
            "</script>")
    public int countBasActivity(BasPageUtil basPageUtil);

    @Select("select * from bas_activity where dict_id=#{dict_id}")
    public BasActivity findById(@Param("dict_id") int dict_id);

    @Update("update bas_activity set dict_type=#{dict_type},dict_item=#{dict_item},dict_value=#{dict_value},dict_id_editable=#{dict_id_editable} where dict_id=#{dict_id}")
    public int updateBas(BasActivity basActivity);

    @Delete("delete from bas_activity where dict_id=#{dict_id}")
    public int delBas(@Param("dict_id") int dict_id);

    @Insert("insert into bas_activity (dict_type,dict_item,dict_value,dict_id_editable) values (#{dict_type},#{dict_item},#{dict_value},#{dict_id_editable})")
    public int addBas(BasActivity basActivity);

}

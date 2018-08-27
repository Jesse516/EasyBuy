package org.crm.mapper;
import org.apache.ibatis.annotations.*;
import org.crm.Util.PageUtil;
import org.crm.domain.AslChance;
import java.util.List;

public interface AslChanceMapper {

    @Select("<script>" +
            "select * from asl_chance where 1=1 " +
            "<if test=\"cust_name!=null and cust_name!='' \">and chc_cust_name like concat('%',#{cust_name},'%')</if>" +
            "<if test=\"c_title!=null and c_title!='' \">and chc_title like concat('%',#{c_title},'%')</if>" +
            "<if test=\"linkManName!=null and linkManName!='' \">and chc_linkman like concat('%',#{linkManName},'%')</if>" +
            "limit #{pageNo},#{pageSize}" +
            "</script>")
    public List<AslChance> findAslChanceByPage(PageUtil pageUtil);//按条件分页查询所有qhq

    @Select("<script>" +
            "select count(1) from asl_chance where 1=1 " +
            "<if test=\"cust_name!=null and cust_name!='' \">and chc_cust_name like concat('%',#{cust_name},'%')</if>" +
            "<if test=\"c_title!=null and c_title!='' \">and chc_title like concat('%',#{c_title},'%')</if>" +
            "<if test=\"linkManName!=null and linkManName!='' \">and chc_linkman like concat('%',#{linkManName},'%')</if>" +
            "</script>")
    public int getCountRecord(PageUtil pageUtil);//按条件查询总数

    @Insert("insert into asl_chance (chc_source,chc_cust_name,chc_title,chc_rate,chc_linkman,chc_tel,chc_desc,chc_create_id,chc_create_by,chc_create_date,chc_due_id,chc_due_to,chc_due_date,chc_status) " +
            "values (#{chc_source},#{chc_cust_name},#{chc_title},#{chc_rate},#{chc_linkman},#{chc_tel},#{chc_desc},#{chc_create_id},#{chc_create_by},#{chc_create_date},#{chc_due_id},#{chc_due_to},#{chc_due_date},#{chc_status})")
    public int addAslChance(AslChance aslChance);//添加功能

    //按编号查找数据
    @Select("select * from asl_chance where chc_id=#{chc_id}")
    public AslChance findById(@Param("chc_id") int chc_id);

    //修改功能
    @Update("update asl_chance set chc_source=#{chc_source},chc_cust_name=#{chc_cust_name},chc_title=#{chc_title},chc_rate=#{chc_rate},chc_linkman=#{chc_linkman},chc_tel=#{chc_tel},chc_desc=#{chc_desc},chc_due_to=#{chc_due_to},chc_due_date=#{chc_due_date},chc_status=#{chc_status} where chc_id=#{chc_id}")
    public int updateChance(AslChance aslChance);

    @Update("update asl_chance set chc_status=#{chc_status} where chc_id=#{chc_id}")
    public int updateStatus(AslChance aslChance);

    @Update("update asl_chance set chc_isdelete=0 where chc_id=#{chc_id}")
    public int deleteChance(@Param("chc_id") int chc_id);

}

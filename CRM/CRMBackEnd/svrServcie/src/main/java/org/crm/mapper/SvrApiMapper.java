package org.crm.mapper;

import org.apache.ibatis.annotations.*;
import org.crm.domain.SvrApi;
import org.crm.util.PageUtil;

import java.util.List;

public interface SvrApiMapper {
    @Insert("insert into cst_service (svr_type,svr_title,svr_cust_name,svr_status,svr_request,svr_create_id,svr_create_by,svr_create_date," +
            "svr_due_id,svr_due_to,svr_due_date,svr_deal,svr_deal_id,svr_deal_by,svr_deal_date,svr_result,svr_satisfy) " +
              "values (#{svr_type},#{svr_title},#{svr_cust_name},#{svr_status},#{svr_request},#{svr_create_id},#{svr_create_by}," +
              "#{svr_create_date},#{svr_due_id},#{svr_due_to},#{svr_due_date},#{svr_deal},#{svr_deal_id},#{svr_deal_by},#{svr_deal_date}," +
              "#{svr_result},#{svr_satisfy})")
    public int addSvrApi(SvrApi svrApi);

    @Select("<script>" +
                "select * from cst_service where 1=1 " +
                "<if test=\"svr_cust_name!=null and svr_cust_name!=''\">and svr_cust_name like concat('%',#{svr_cust_name},'%')</if>" +
                "<if test=\"svr_title!=null and svr_title!=''\">and svr_title like concat('%',#{svr_title},'%')</if>" +
                "<if test=\"svr_status!=null and svr_status=='已反馈'\">and svr_status like concat('%','已反馈','%')</if>" +
                 "<if test=\"svr_status!=null and svr_status=='新创建'\">and svr_status like concat('%','新创建','%')</if>" +
                "<if test=\"svr_status!=null and svr_status=='已分配'\">and svr_status like concat('%','已分配','%')</if>" +
                "<if test=\"svr_status!=null and svr_status=='已处理'\">and svr_status like concat('%','已处理','%')</if>" +
    "<if test=\"start_svr_create_date!=null and start_svr_create_date!=''\">and svr_create_date &gt; #{start_svr_create_date}</if>" +
    "<if test=\"end_svr_create_date!=null and end_svr_create_date!=''\">and svr_create_date &lt; #{end_svr_create_date}</if>" +
                "<if test=\"svr_type!=null and svr_type!=''\">and svr_type like concat('%',#{svr_type},'%')</if>" +
                "limit #{pageNo},#{pageSize}" +
            "</script>")
    public List<SvrApi> findAllSvrApi(PageUtil pageUtil);//分页显示


    @Select("<script>" +
                "select count(1) from cst_service where 1=1 " +
                "<if test=\"svr_cust_name!=null and svr_cust_name!=''\">and svr_cust_name like concat('%',#{svr_cust_name},'%')</if>" +
                "<if test=\"svr_title!=null and svr_title!=''\">and svr_title like concat('%',#{svr_title},'%')</if>" +
                "<if test=\"svr_status!=null and svr_status=='已反馈'\">and svr_status like concat('%','已反馈','%')</if>" +
                 "<if test=\"svr_status!=null and svr_status=='新创建'\">and svr_status like concat('%','新创建','%')</if>" +
                "<if test=\"svr_status!=null and svr_status=='已分配'\">and svr_status like concat('%','已分配','%')</if>" +
                 "<if test=\"svr_status!=null and svr_status=='已处理'\">and svr_status like concat('%','已处理','%')</if>" +
            "<if test=\"start_svr_create_date!=null and start_svr_create_date!=''\">and svr_create_date &gt; #{start_svr_create_date}</if>" +
            "<if test=\"end_svr_create_date!=null and end_svr_create_date!=''\">and svr_create_date &lt; #{end_svr_create_date}</if>" +
                "<if test=\"svr_type!=null and svr_type!=''\">and svr_type like concat('%',#{svr_type},'%')</if>" +
            "</script>")
    public int countSvrApi(PageUtil pageUtil);//计算总条目

    @Update("<script>update cst_service" +
                "<set> " +
                "<if test=\"svr_due_id!=null and svr_due_id!=''\">svr_due_id=#{svr_due_id},</if>" +
                "<if test=\"svr_due_to!=null and svr_due_to!=''\">svr_due_to=#{svr_due_to},</if>" +
                "<if test=\"svr_due_date!=null \">svr_due_date=#{svr_due_date},</if>" +
                "<if test=\"svr_status!=null and svr_status='已处理'\">svr_status='已归档',</if>" +
                "<if test=\"svr_status!=null and svr_status='已分配'\">svr_status='已处理',</if>" +
                 "<if test=\"svr_status!=null and svr_status='新创建'\">svr_status='已分配',</if>" +
                "<if test=\"svr_deal!=null and svr_deal!=''\">svr_deal=#{svr_deal},</if>" +
                "<if test=\"svr_deal_by!=null and svr_deal_by!=''\">svr_deal_by=#{svr_deal_by},</if>" +
                "<if test=\"svr_deal_date!=null \">svr_deal_date=#{svr_deal_date},</if>" +
                "<if test=\"svr_result!=null and svr_result!=''\">svr_result=#{svr_result},</if>" +
                "<if test=\"svr_satisfy!=null and svr_satisfy!=''\">svr_satisfy=#{svr_satisfy},</if>" +
                "</set> " +
                "where svr_id=#{svr_id}" +
            "</script>")
    public int updateSvr(SvrApi svrApi);



    @Update("<script>update cst_service" +
            "<set> " +
                "<if test=\"svr_status!=null and svr_status!=''\">svr_status=#{svr_status},</if>" +
                "<if test=\"svr_deal!=null and svr_deal!=''\">svr_deal=#{svr_deal},</if>" +
                "<if test=\"svr_deal_by!=null and svr_deal_by!=''\">svr_deal_by=#{svr_deal_by},</if>" +
                "<if test=\"svr_deal_date!=null \">svr_deal_date=#{svr_deal_date},</if>" +
                "<if test=\"svr_result!=null and svr_result!=''\">svr_result=#{svr_result},</if>" +
                "<if test=\"svr_satisfy!=null and svr_satisfy!=''\">svr_satisfy=#{svr_satisfy},</if>" +
            "</set> " +
            "where svr_id=#{svr_id}" +
            "</script>")
    public int dealDetailSvr(SvrApi svrApi);//服务处理



    @Update("<script>update cst_service" +
            "<set> " +
                "<if test=\"svr_status!=null and svr_status!=''\">svr_status=#{svr_status},</if>" +
                "<if test=\"svr_result!=null and svr_result!=''\">svr_result=#{svr_result},</if>" +
                "<if test=\"svr_satisfy!=null and svr_satisfy!=''\">svr_satisfy=#{svr_satisfy},</if>" +
            "</set> " +
            "where svr_id=#{svr_id}" +
            "</script>")
    public int feedback(SvrApi svrApi);//反馈处理





    @Delete("delete from cst_service where svr_id=#{svr_id}")
    public  int deleteSvr(@Param("svr_id") int svr_id);

    @Select("select * from cst_service where svr_id=#{svr_id}")
    public SvrApi findById(@Param("svr_id") int svr_id);

    @Select("<script>" +
                "SELECT svr_type,COUNT(svr_type) number FROM cst_service WHERE 1=1 " +
                "<if test=\"year!=null and year!=0\"> AND  YEAR(svr_create_date)=#{year}</if> " +
                "GROUP BY  svr_type" +
            "</script>")
    public List<SvrApi> findList(@Param("year") int year);

}

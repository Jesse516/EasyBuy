package org.crm.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.crm.domain.CstLost;
import java.util.List;
public interface CstLostMapper {

    //分页显示所有
   /* @Select("select * from cst_lost LIMIT #{pageno},#{pagesize}")*/
    @Select("<script>" +
            "select *,YEAR(lst_lost_date) lostyear from cst_lost where 1=1" +
            "<if test=\"lst_cust_name!=null and lst_cust_name!='' \"> and lst_cust_name like concat('%',#{lst_cust_name},'%')</if>" +
            "<if test=\"lst_manager_name!=null and lst_manager_name!='' \"> and lst_manager_name like concat('%',#{lst_manager_name},'%')</if>" +
            "<if test=\"lst_status!=null and lst_status!='' \"> and lst_status like concat('%',#{lst_status},'%')</if>" +
            "limit #{pageno},#{pagesize}" +
            "</script>")
    public List<CstLost> findAllLostByPage(CstLost cstLost);


    //计算客户流失表里面的记录总数
    @Select("<script>" +
            "select count(1) from cst_lost" +
                "<where>" +
                    "<if test=\"lst_cust_name!=null and lst_cust_name!='' \"> and lst_cust_name like concat('%',#{lst_cust_name},'%')</if>" +
                    "<if test=\"lst_manager_name!=null and lst_manager_name!='' \"> and lst_manager_name like concat('%',#{lst_manager_name},'%')</if>" +
                    "<if test=\"lst_status!=null and lst_status!='' \"> and lst_status like concat('%',#{lst_status},'%')</if>" +
                "</where>" +
            "</script>")
    public int totleRecord(CstLost cstLost);


    //根据编号查找
    @Select("select * from cst_lost where lst_id=#{lst_id}")
    public CstLost findCstLostById(@Param("lst_id") int lst_id);

    //确认流失修改客户内容（添加流失原因，流失时间，状态改为确认流失）
    @Update("update cst_lost set lst_lost_date=#{lst_lost_date},lst_reason=#{lst_reason},lst_status='确认流失' where lst_id=#{lst_id}")
    public int updateCstLostconfirm(CstLost cstLost);

    //暂缓流失修改客户内容（追加暂缓措施内容，状态改为暂缓流失）
    @Update("update cst_lost set lst_delay=#{lst_delay},lst_status='暂缓流失' where lst_id=#{lst_id}")
    public int updateCstLostreply(CstLost cstLost);
}

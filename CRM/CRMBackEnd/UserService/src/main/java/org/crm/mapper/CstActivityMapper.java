package org.crm.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.crm.domain.Consumer;
import org.crm.domain.CstActivity;
import java.util.List;

public interface CstActivityMapper {
    @Select("select * from cst_activity where atv_cust_no=#{atv_cust_no}")
    public List<CstActivity> findAllCstActivity(@Param("atv_cust_no") String atv_cust_no);

    @Select("select * from cst_activity where atv_id=#{atv_id}")
    public CstActivity findActivityById(@Param("atv_id") int atv_id);

    @Update("update cst_activity set atv_date=#{atv_date},atv_place=#{atv_place},atv_title=#{atv_title},atv_desc=#{atv_desc},atv_memo=#{atv_memo} where atv_id=#{atv_id}")
    public int updateActivityById(CstActivity cstActivity);

    @Update("delete from cst_activity  where atv_id=#{atv_id}")
    public int deleteActivityById(@Param("atv_id") int atv_id);

    @Insert("insert into cst_activity (atv_cust_no,atv_cust_name,atv_date,atv_place,atv_title,atv_desc,atv_memo) values (#{atv_cust_no},#{atv_cust_name},#{atv_date},#{atv_place},#{atv_title},#{atv_desc},#{atv_memo})")
    public int addActivity(CstActivity cstActivity);
}

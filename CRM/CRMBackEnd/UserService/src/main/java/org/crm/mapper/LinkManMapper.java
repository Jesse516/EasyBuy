package org.crm.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.crm.domain.LinkMan;

import java.util.List;

public interface LinkManMapper {
    @Select("select * from cst_linkman where lkm_status=1 and lkm_cust_no=#{lkm_cust_no}")
    public List<LinkMan> findAllLinkman(@Param("lkm_cust_no") String lkm_cust_no);

    @Select("select * from cst_linkman where lkm_status<>0 and lkm_id=#{lkm_id}")
    public LinkMan findById(@Param("lkm_id") int lkm_id);

    @Update("update cst_linkman set lkm_sex=#{lkm_sex},lkm_postion=#{lkm_postion}," +
            "lkm_tel=#{lkm_tel},lkm_mobile=#{lkm_mobile},lkm_memo=#{lkm_memo} where lkm_id=#{lkm_id}")
    public int updateLinkManById(LinkMan linkMan);

    @Insert("insert into cst_linkman (lkm_cust_no,lkm_name,lkm_sex,lkm_postion,lkm_tel,lkm_mobile,lkm_memo,lkm_status) " +
            "values (#{lkm_cust_no},#{lkm_name},#{lkm_sex},#{lkm_postion},#{lkm_tel},#{lkm_mobile},#{lkm_memo},1)")
    public int addLinkMan(LinkMan linkMan);

    @Update("update cst_linkman set lkm_status=0 where lkm_id=${lkm_id}" )
    public int deleteLinkManById(@Param("lkm_id") int lkm_id);
}

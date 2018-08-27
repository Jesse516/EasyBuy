package org.crm.service.impl;
import org.crm.Util.JWTHelper;
import org.crm.Util.PageUtil;
import org.crm.domain.AslChance;
import org.crm.domain.SalPlan;
import org.crm.mapper.AslChanceMapper;
import org.crm.mapper.SalPlanMapper;
import org.crm.service.AslChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AslChanceServiceImpl implements AslChanceService {
    @Autowired
    private AslChanceMapper acMapper;
    @Autowired
    private SalPlanMapper salPlanMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<AslChance> findAslChanceByPage(PageUtil pageUtil) {
        int pageNo=pageUtil.getPageNo();
        int pageSize=pageUtil.getPageSize();
        if(pageNo!=0){
            pageUtil.setPageNo((pageNo-1)*pageSize);
        }

        return acMapper.findAslChanceByPage(pageUtil);
    }

    @Override
    public int getCountRecord(PageUtil pageUtil) {
        return acMapper.getCountRecord(pageUtil);
    }

    @Override
    public int getCountPage(PageUtil pageUtil) {
        int totle=acMapper.getCountRecord(pageUtil);
        return totle%pageUtil.getPageSize()==0 ? totle/pageUtil.getPageSize() : totle/pageUtil.getPageSize()+1;
    }

    @Override
    public int addAslChance(AslChance aslChance) {
        //获取页面传过来的token
        String token=aslChance.getToken();
        //解析token成Map集合
        Map<String,String> map=JWTHelper.verifyToken(token);
        //从token中获取登陆者用户名（也就是创建者姓名），然后重新设置对像chc_create_by值
        aslChance.setChc_create_by(map.get("username"));
        //从token中获取登陆者用户名（也就是创建者id），然后重新设置对像chc_create_id值
        aslChance.setChc_create_id(Integer.parseInt(map.get("userid")));
        System.out.println(aslChance);
        return acMapper.addAslChance(aslChance);
    }

    @Override
    public AslChance findById(int chc_id) {
        List<SalPlan> list=salPlanMapper.findByplanId(chc_id);//根据机会编号查找此机会下所有计划列表明细，重新赋值
        AslChance chance=acMapper.findById(chc_id);
        chance.setPlan(list);
        return chance;
    }

    @Override
    public int updateChance(AslChance aslChance) {
        return acMapper.updateChance(aslChance);
    }

    @Override
    public int deleteChance(int chc_id) {
        return acMapper.deleteChance(chc_id);
    }

    @Override
    public int updateStatus(AslChance aslChance) {
        return acMapper.updateStatus(aslChance);
    }
}

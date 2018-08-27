package org.crm.service.impl;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import org.crm.domain.SysUser;
import org.crm.mapper.UserMapper;
import org.crm.service.UserService;
import org.crm.util.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;//StringRedisTemplate为架包内封装类，自带有方法下面要用到

    @Override
    public SysUser findByNameAndPwd(String usr_name, String usr_password) {
        SysUser user=userMapper.findByNameAndPwd(usr_name,usr_password);
        if(user!=null){
            //利用工具类JWTHelper封装好的方法genToken来生成token，参数需要一个map集合，这里又用到google提供的ImmutableMap自动生成map集合方法
            //String token=JWTHelper.genToken(ImmutableMap.of("username",user.getUsr_name(),"userid",user.getUsr_id()+"","ts",Instant.now().getEpochSecond()+""));
            String token=JWTHelper.genToken(ImmutableMap.of("username",user.getUsr_name(),"userid",user.getUsr_id()+""));
            //      《------------如果不想用ImmutableMap自动生成map集合，也可以按照以下传统写法---------》
                      /* Map<String,String> map=new HashMap<String,String>();
                       map.put("username",user.getUsr_name());
                       map.put("password",user.getUsr_password());
                       map.put("password",getUsr_id()+"");
                       Calendar c=Calendar.getInstance();
                       Date time=new Date(c.getTimeInMillis());//或者写Date d=c.getTime()；也可以
                       map.put("ts",time);//将时间戳存入map集合

                       String token=JWTHelper.genToken(map);//生成token
                       // 以下是获得当前时间戳方法
                       */

            //往Redis中存放生成的token，key为用户名，value为token
            redisTemplate.opsForValue().set(user.getUsr_name(),token);
            //设置上一步存在在Redis中数据的有效期限为：30分
            redisTemplate.expire(user.getUsr_name(),30,TimeUnit.MINUTES);
            user.setToken(token);
        }
        return user;
    }


    //封装一个从token判断用户是否登陆过
    public  SysUser getUserByToken(String token){
        //如果参数token为空，则根本没登录过
        if(Strings.isNullOrEmpty(token)){
            return null;
        }
        //解析token,反序列化
        Map<String,String> map=JWTHelper.verifyToken(token);
        //从token获取用户名
        String username=map.get("username");
        int userId=Integer.parseInt(map.get("userid"));
        //从Redis中查询该用户token剩余时间，如果过期或者查询不到结果，则获取失败
        Long expired=redisTemplate.getExpire("username");
        if(expired>0L){
            //如果获取到，则重置token内容，并且返回用户
            SysUser user=this.findById(userId);//通过id查找到对应用户
            //为了避免token中存入用户某些信息在数据库中已经更改，所有要重新生成map,再最新token，然后在存入Redis中
            Map<String,String> s_map=ImmutableMap.of("username",user.getUsr_name(),"userid",user.getUsr_id()+"","ts",Instant.now().getEpochSecond()+"");
            token=JWTHelper.genToken(s_map);//重新生成最新token
            redisTemplate.opsForValue().set(username,token);
            //重置token时间从当前开始算起
            redisTemplate.expire(username,30,TimeUnit.MINUTES);
            user.setToken(token);
            return user;
        }
        return  null;
    }

    //退出功能
    public void logOut(String token){
        Map<String,String> map=JWTHelper.verifyToken(token);
        redisTemplate.delete(map.get("username"));
    }



    @Override
    public List<SysUser> findAllSysUser() {
        return userMapper.findAllSysUser();
    }

    @Override
    public SysUser findById(int usr_id) {
        return userMapper.findById(usr_id);
    }
}
